package com.pratishthakapoor.gomovie.data.network;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.pratishthakapoor.gomovie.data.network.response.FbFriendsResponse;
import com.pratishthakapoor.gomovie.data.network.response.LoginResponse;
import com.pratishthakapoor.gomovie.data.network.response.MovieInfoResponse;
import com.pratishthakapoor.gomovie.data.network.response.ReviewListResponse;
import com.pratishthakapoor.gomovie.data.network.response.SearchResponse;
import com.pratishthakapoor.gomovie.data.network.response.UserInfoResponse;
import com.pratishthakapoor.gomovie.model.Comment;
import com.pratishthakapoor.gomovie.model.Feed;
import com.pratishthakapoor.gomovie.model.FeedGroup;
import rx.Observable;

/**
 * Created by tanmayvijayvargiya on 12/02/17.
 */
public class ApiHelperImpl implements ApiHelper{

    private final ApiService apiService;
    @Inject
    public ApiHelperImpl(ApiService apiService) {
        this.apiService = apiService;
    }


    @Override
    public Observable<LoginResponse> login(String userId, String username, String accessToken, String emailId) {
        return apiService.login(emailId,username,accessToken,userId);
    }

    @Override
    public Observable<List<Feed>> getUserTimeline(String userId) {
        return apiService.userTimeline(userId);
    }

    @Override
    public Observable<List<Feed>> getMovieFeed(String userId, String fromId) {
        return apiService.movieFeed(userId, fromId);
    }

    @Override
    public Observable<MovieInfoResponse> movieInfo(String movieId) {
        return apiService.movieInfo(movieId);
    }

    @Override
    public Observable<UserInfoResponse> getUserInfo(String sessionId, String userId) {
        return apiService.getUserInfo(sessionId, userId);
    }

    @Override
    public Observable<List<FbFriendsResponse>> getFBFriends(String userId, String accessToken) {
        return apiService.getFBFriends(userId, accessToken);
    }

    @Override
    public Observable<NetworkResponse> addToWishList(String sessionId, String movieId) {
        return apiService.addToWishList(sessionId, movieId);
    }

    @Override
    public Observable<NetworkResponse> addToSeenList(String sessionId, String movieId) {
        return apiService.addToSeenList(sessionId, movieId);
    }

    @Override
    public Observable<NetworkResponse> removeFromSeenList(String sessionId, String movieId) {
        return apiService.removeFromSeenList(sessionId, movieId);
    }

    @Override
    public Observable<NetworkResponse> removeFromWishList(String sessionId, String movieId) {
        return apiService.removeFromWishList(sessionId, movieId);
    }

    @Override
    public Observable<NetworkResponse> setUserPreferences(String userId, List<String> languages) {
        return null;
    }

    @Override
    public Observable<NetworkResponse> followMany(String userId, List<String> followList) {
        return apiService.followMany(userId, (ArrayList<String>) followList);
    }

    @Override
    public Observable<NetworkResponse> unFollowMany(String userId, List<String> unfollowList) {
        return apiService.unFollowMany(userId, (ArrayList<String>) unfollowList);
    }

    @Override
    public Observable<SearchResponse> search(String query) {
        return apiService.search(query);
    }

    @Override
    public Observable<NetworkResponse> createMovieReview(String userId, String sessionId, String movieId, String movieReview, float movieRating) {
        return apiService.createMovieReview(userId, sessionId, movieId, movieReview, movieRating);
    }

    @Override
    public Observable<ReviewListResponse> getReviewsOfMovie(String movieId, int index, int count) {
        return apiService.getReviewsOfMovie(movieId, index, count);
    }

    @Override
    public Observable<ReviewListResponse> getReviewsOfUser(String userId, int index, int count) {
        return apiService.getReviewsOfUser(userId, index, count);
    }

    @Override
    public Observable<NetworkResponse> likeActivity(String userId, String foreignId, boolean doLike) {
        return apiService.likeActivity(userId, foreignId, doLike);
    }

    @Override
    public Observable<NetworkResponse> commentOnActivity(String userId, String foreignId, String comment) {
        return apiService.commentOnActivity(userId, foreignId, comment);
    }

    @Override
    public Observable<List<Feed>> getUserTimeline(String userId, String fromId) {
        return apiService.userTimeline(userId, fromId);
    }

    @Override
    public Observable<List<FeedGroup>> userFollowingFeed(String userid) {
        return apiService.userFollowingFeed(userid);
    }

    @Override
    public Observable<List<Comment>> getActivityComments(String userId, String foreignId) {
        return apiService.getActivityComments(userId, foreignId);
    }

}
