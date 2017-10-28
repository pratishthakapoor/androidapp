package com.pratishthakapoor.gomovie.data.network;

import java.util.ArrayList;
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
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by tanmayvijayvargiya on 21/03/17.
 */
public interface ApiService {
    @POST("/feed/login")
    @FormUrlEncoded
    Observable<LoginResponse> login(@Field("userLoginId") String userLoginId, @Field("username") String username,
                                    @Field("accessToken") String accessToken, @Field("userId") String userId);

    @GET("/feed/userTimeline")
    Observable<List<Feed>> userTimeline(@Query("userId") String userid);
    @GET("/feed/myFollowingFeed")
    Observable<List<FeedGroup>> userFollowingFeed(@Query("userId") String userid);
    @GET("/feed/search")
    Observable<SearchResponse> search(@Query("q") String query);

    @GET("/feed/movieFeed")
    Observable<List<Feed>> movieFeed(@Query("userId") String userid, @Query("fromId") String fromId);
    @GET("/feed/getFBFriends")
    Observable<List<FbFriendsResponse>> getFBFriends(@Query("userId") String userid, @Query("accessToken") String accessToken);
    @GET("/feed/movieInfo")
    Observable<MovieInfoResponse> movieInfo(@Query("movieId") String movieId);

    @POST("/feed/createMovieReview")
    @FormUrlEncoded
    Observable<NetworkResponse> createMovieReview(@Field("userId") String userId, @Field("sessionId") String sessionId, @Field("movieId") String movieId, @Field("movieReview") String movieReview, @Field("movieRating") float movieRating);
    @POST("/feed/getReviewsOfMovie")
    @FormUrlEncoded
    Observable<ReviewListResponse> getReviewsOfMovie(@Field("movieId") String movieId, @Field("index") int index, @Field("count") int count);
    @POST("/feed/getReviewsOfUser")
    @FormUrlEncoded
    Observable<ReviewListResponse> getReviewsOfUser(@Field("userId") String userId, @Field("index") int index, @Field("count") int count);

    @POST("/feed/addToWishList")
    @FormUrlEncoded
    Observable<NetworkResponse> addToWishList(@Field("sessionId") String sessionId, @Field("movieId") String movieId);
    @POST("/feed/userInfo")
    @FormUrlEncoded
    Observable<UserInfoResponse> getUserInfo(@Field("sessionId") String sessionId, @Field("userId") String userId);

    @POST("/feed/addToSeenList")
    @FormUrlEncoded
    Observable<NetworkResponse> addToSeenList(@Field("sessionId") String sessionId, @Field("movieId") String movieId);
    @POST("/feed/removeFromWishList")
    @FormUrlEncoded
    Observable<NetworkResponse> removeFromWishList(@Field("sessionId") String sessionId, @Field("movieId") String movieId);
    @POST("/feed/removeFromSeenList")
    @FormUrlEncoded
    Observable<NetworkResponse> removeFromSeenList(@Field("sessionId") String sessionId, @Field("movieId") String movieId);

    @POST("/feed/followMany")
    @FormUrlEncoded
    Observable<NetworkResponse> followMany(@Field("userId") String userId, @Field("followList[]") ArrayList<String> followList);

    @POST("/feed/likeActivity")
    @FormUrlEncoded
    Observable<NetworkResponse> likeActivity(@Field("userId") String userId, @Field("foreign_id") String foreignId, @Field("doLike") boolean doLike);
    @POST("/feed/commentOnActivity")
    @FormUrlEncoded
    Observable<NetworkResponse> commentOnActivity(@Field("userId") String userId, @Field("foreign_id") String foreignId, @Field("comment") String comment);
    @POST("/feed/getActivityComments")
    @FormUrlEncoded
    Observable<List<Comment>> getActivityComments(@Field("userId") String userId, @Field("foreign_id") String foreignId);

    @POST("/feed/unFollowMany")
    @FormUrlEncoded
    Observable<NetworkResponse> unFollowMany(@Field("userId") String userId, @Field("unfollowList[]") ArrayList<String> unfollowList);

    @GET("/feed/userTimeline")
    Observable<List<Feed>> userTimeline(@Query("userId") String userId, @Query("fromId") String fromId);
}
