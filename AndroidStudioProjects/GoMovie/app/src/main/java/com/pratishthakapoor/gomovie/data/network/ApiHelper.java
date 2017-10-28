package com.pratishthakapoor.gomovie.data.network;

import java.util.List;

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
public interface ApiHelper {
    Observable<LoginResponse> login(String userId, String accessToken, String username, String emailId);
    Observable<List<Feed>> getUserTimeline(String userId);
    Observable<List<Feed>> getMovieFeed(String userId, String fromId);
    Observable<MovieInfoResponse> movieInfo(String movieId);
    Observable<UserInfoResponse> getUserInfo(String sessionId, String userId);
    Observable<List<FbFriendsResponse>> getFBFriends(String userId, String accessToken);
    Observable<NetworkResponse> addToWishList(String sessionId, String movieId);
    Observable<NetworkResponse> addToSeenList(String sessionId, String movieId);
    Observable<NetworkResponse> removeFromSeenList(String sessionId, String movieId);
    Observable<NetworkResponse> removeFromWishList(String sessionId, String movieId);
    Observable<NetworkResponse> setUserPreferences(String userId, List<String> languages);
    Observable<NetworkResponse> followMany(String userId, List<String> followList);
    Observable<NetworkResponse> unFollowMany(String userId, List<String> unfollowList);
    Observable<SearchResponse> search(String query);
    Observable<NetworkResponse> createMovieReview(String userID, String sessionId, String movieId, String movieReview, float movieRating);
    Observable<ReviewListResponse> getReviewsOfMovie(String movieId, int index, int count);
    Observable<ReviewListResponse> getReviewsOfUser(String userId, int index, int count);
    Observable<NetworkResponse> likeActivity(String userId, String foreignId, boolean doLike);
    Observable<NetworkResponse> commentOnActivity(String userId, String foreignId, String comment);
    Observable<List<Feed>> getUserTimeline(String userId, String fromId);
    Observable<List<FeedGroup>> userFollowingFeed(String userid);
    Observable<List<Comment>> getActivityComments(String userId, String foreignId);
}
