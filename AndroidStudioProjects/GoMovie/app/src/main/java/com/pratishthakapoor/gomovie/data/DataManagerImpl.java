package com.pratishthakapoor.gomovie.data;

import android.content.Context;

import com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction;

import java.util.List;

import javax.inject.Inject;

import com.pratishthakapoor.gomovie.data.db.DbHelper;
import com.pratishthakapoor.gomovie.data.network.ApiHelper;
import com.pratishthakapoor.gomovie.data.network.NetworkResponse;
import com.pratishthakapoor.gomovie.data.network.OfbizApiHelper;
import com.pratishthakapoor.gomovie.data.network.response.FbFriendsResponse;
import com.pratishthakapoor.gomovie.data.network.response.LoginResponse;
import com.pratishthakapoor.gomovie.data.network.response.MovieInfoResponse;
import com.pratishthakapoor.gomovie.data.network.response.ReviewListResponse;
import com.pratishthakapoor.gomovie.data.network.response.SearchResponse;
import com.pratishthakapoor.gomovie.data.network.response.UserInfoResponse;
import com.pratishthakapoor.gomovie.data.prefs.PreferenceHelper;
import com.pratishthakapoor.gomovie.di.ApplicationContext;
import com.pratishthakapoor.gomovie.model.Comment;
import com.pratishthakapoor.gomovie.model.Feed;
import com.pratishthakapoor.gomovie.model.FeedGroup;
import com.pratishthakapoor.gomovie.model.MovieStat;
import rx.Observable;

/**
 * Created by tanmayvijayvargiya on 12/02/17.
 */
public class DataManagerImpl implements DataManager {

    private final Context context;
    private final DbHelper dbHelper;
    private final PreferenceHelper preferenceHelper;
    private final ApiHelper apiHelper;

    @Inject //1
    public DataManagerImpl(@ApplicationContext Context context,
                           DbHelper dbHelper,
                           PreferenceHelper preferenceHelper,
                           ApiHelper apiHelper,
                           OfbizApiHelper ofbizApiHelper) {
        this.context = context;
        this.dbHelper = dbHelper;
        this.preferenceHelper = preferenceHelper;
        this.apiHelper = apiHelper;
    }

    @Override
    public void setCurrentUserId(String userId) {
        preferenceHelper.setCurrentUserId(userId);
    }

    @Override
    public String getCurrentUserid() {
        return preferenceHelper.getCurrentUserid();
    }

    @Override
    public void setCurrentUserName(String userName) {
        preferenceHelper.setCurrentUserName(userName);
    }

    @Override
    public String getCurrentUserName() {
        return preferenceHelper.getCurrentUserName();
    }

    @Override
    public void setSessionId(String sessionId) {
        preferenceHelper.setSessionId(sessionId);
    }

    @Override
    public String getSessionId() {
        return preferenceHelper.getSessionId();
    }

    @Override
    public Observable<LoginResponse> login(String userId, String username, String accessToken, String emailId) {
        return apiHelper.login(userId, username, accessToken, emailId);
    }

    @Override
    public Observable<List<Feed>> getUserTimeline(String userId) {
        return apiHelper.getUserTimeline(userId);
    }

    @Override
    public Observable<List<Feed>> getMovieFeed(String userId, String fromId) {
        return apiHelper.getMovieFeed(userId, fromId);
    }

    @Override
    public Observable<MovieInfoResponse> movieInfo(String movieId) {
        return apiHelper.movieInfo(movieId);
    }

    @Override
    public Observable<UserInfoResponse> getUserInfo(String sessionId, String userId) {
        return apiHelper.getUserInfo(sessionId, userId);
    }

    @Override
    public Observable<List<FbFriendsResponse>> getFBFriends(String userId, String accessToken) {
        return apiHelper.getFBFriends(userId, accessToken);
    }

    @Override
    public Observable<NetworkResponse> addToWishList(String sessionId, String movieId) {
        MovieStat movieStat = new MovieStat(movieId);
        movieStat.setInWantToWatchList(true);
        movieStat.save();
        return apiHelper.addToWishList(sessionId, movieId);
    }

    @Override
    public Observable<NetworkResponse> addToSeenList(String sessionId, String movieId) {
        MovieStat movieStat = new MovieStat(movieId);
        movieStat.setInSeenList(true);
        movieStat.save();
        return apiHelper.addToSeenList(sessionId, movieId);
    }

    @Override
    public Observable<NetworkResponse> removeFromSeenList(String sessionId, String movieId) {
        MovieStat movieStat = new MovieStat(movieId);
        movieStat.setInSeenList(false);
        movieStat.save();
        return apiHelper.removeFromSeenList(sessionId, movieId);
    }

    @Override
    public Observable<NetworkResponse> removeFromWishList(String sessionId, String movieId) {
        MovieStat movieStat = new MovieStat(movieId);
        movieStat.setInWantToWatchList(false);
        movieStat.save();
        return apiHelper.removeFromWishList(sessionId, movieId);
    }

    @Override
    public Observable<NetworkResponse> setUserPreferences(String userId, List<String> languages) {
        return apiHelper.setUserPreferences(userId, languages);
    }

    @Override
    public Observable<NetworkResponse> followMany(String userId, List<String> followList) {
        return apiHelper.followMany(userId, followList);
    }

    @Override
    public Observable<NetworkResponse> unFollowMany(String userId, List<String> unfollowList) {
        return apiHelper.unFollowMany(userId, unfollowList);
    }

    @Override
    public Observable<SearchResponse> search(String query) {
        return apiHelper.search(query);
    }

    @Override
    public Observable<NetworkResponse> createMovieReview(String userId ,String sessionId, String movieId, String movieReview, float movieRating) {
        return apiHelper.createMovieReview(userId,sessionId, movieId, movieReview, movieRating);
    }

    @Override
    public Observable<ReviewListResponse> getReviewsOfMovie(String movieId, int index, int count) {
        return apiHelper.getReviewsOfMovie(movieId, index, count);
    }

    @Override
    public Observable<ReviewListResponse> getReviewsOfUser(String userId, int index, int count) {
        return apiHelper.getReviewsOfUser(userId, index, count);
    }

    @Override
    public Observable<NetworkResponse> likeActivity(String userId, String foreignId, boolean doLike) {
        return apiHelper.likeActivity(userId, foreignId, doLike);
    }

    @Override
    public Observable<NetworkResponse> commentOnActivity(String userId, String foreignId, String comment) {
        return apiHelper.commentOnActivity(userId, foreignId, comment);
    }


    @Override
    public Observable<NetworkResponse> facebookLogin(String userId, String emailId, String username, String accessToken) {
        return null;
    }

    @Override
    public void getMovieStat(String movieId, QueryTransaction.QueryResultSingleCallback<MovieStat> queryCallback , Transaction.Error errorCallback) {
         dbHelper.getMovieStat(movieId, queryCallback, errorCallback);
    }

    @Override
    public Observable<List<Feed>> getUserTimeline(String userId, String fromId) {
        return apiHelper.getUserTimeline(userId,fromId);
    }

    @Override
    public Observable<List<FeedGroup>> userFollowingFeed(String userid) {
        return apiHelper.userFollowingFeed(userid);
    }

    @Override
    public Observable<List<Comment>> getActivityComments(String userId, String foreignId) {
        return apiHelper.getActivityComments(userId, foreignId);
    }
}
