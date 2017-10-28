package com.pratishthakapoor.gomovie.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by tanmayvijayvargiya on 21/03/17.
 */
public class MovieOverview {
    @SerializedName("movieId")
    @Expose
    String movieId;

    @SerializedName("DEFAULT_VIDEO")
    @Expose
    String defaultVideo;
    @SerializedName("DEFAULT_IMAGE")
    @Expose
    String defaultImage;
    @SerializedName("url")
    @Expose
    String url;
    @SerializedName("NAME")
    @Expose
    String name;

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getDefaultVideo() {
        return defaultVideo;
    }

    public void setDefaultVideo(String defaultVideo) {
        this.defaultVideo = defaultVideo;
    }

    public String getDefaultImage() {
        return defaultImage;
    }

    public void setDefaultImage(String defaultImage) {
        this.defaultImage =  defaultImage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
