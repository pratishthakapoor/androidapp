package com.pratishthakapoor.gomovie.data.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by tanmayvijayvargiya on 09/04/17.
 */

public class ReviewOverview {
    @SerializedName("movieReviewId")
    @Expose
    String movieReviewId;
    @SerializedName("movieId")
    @Expose
    String movieId;
    @SerializedName("movieName")
    @Expose
    String movieName;
    @SerializedName("movieRating")
    @Expose
    float movieRating;
    @SerializedName("movieReview")
    @Expose
    String movieReview;
    @SerializedName("movieDefaultPhoto")
    @Expose
    String movieDefaultPhoto;

    @SerializedName("user")
    @Expose
    UserOverview user;

    public String getMovieReviewId() {
        return movieReviewId;
    }

    public String getMovieDefaultPhoto() {
        return movieDefaultPhoto;
    }

    public void setMovieDefaultPhoto(String movieDefaultPhoto) {
        this.movieDefaultPhoto = movieDefaultPhoto;
    }

    public void setMovieReviewId(String movieReviewId) {
        this.movieReviewId = movieReviewId;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public float getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(float movieRating) {
        this.movieRating = movieRating;
    }

    public String getMovieReview() {
        return movieReview;
    }

    public void setMovieReview(String movieReview) {
        this.movieReview = movieReview;
    }

    public UserOverview getUser() {
        return user;
    }

    public void setUser(UserOverview user) {
        this.user = user;
    }
}
