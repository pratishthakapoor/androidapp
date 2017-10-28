package com.pratishthakapoor.gomovie.data.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by tanmayvijayvargiya on 08/04/17.
 */

public class SearchResponse {
    @SerializedName("users")
    @Expose
    List<UserOverview> users;

    @SerializedName("movies")
    @Expose
    List<MovieOverview> movies;

    public List<UserOverview> getUsers() {
        return users;
    }

    public void setUsers(List<UserOverview> users) {
        this.users = users;
    }

    public List<MovieOverview> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieOverview> movies) {
        this.movies = movies;
    }



    public class MovieOverview{
        @SerializedName("movieId")
        @Expose
        public String movieId;
        @SerializedName("name")
        @Expose
        public String movieName;
        @SerializedName("poster_image")
        @Expose
        public String moviePosterUrl;
    }

    public class UserOverview{
        @SerializedName("userId")
        @Expose
        public String userId;
        @SerializedName("userName")
        @Expose
        public String userName;
        @SerializedName("profilePicture")
        @Expose
        public String userProfileUrl;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserProfileUrl() {
            return userProfileUrl;
        }

        public void setUserProfileUrl(String userProfileUrl) {
            this.userProfileUrl = userProfileUrl;
        }
    }
}
