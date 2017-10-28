package com.pratishthakapoor.gomovie.data.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by tanmayvijayvargiya on 02/04/17.
 */
public class MovieInfoResponse {
    @SerializedName("movieid")
    @Expose
    String movieId;
    @SerializedName("NAME")
    @Expose
    String name;
    @SerializedName("DEFAULT_IMAGE")
    @Expose
    String defaultImage;
    @SerializedName("DEFAULT_VIDEO")
    @Expose
    String defaultVideo;
    @SerializedName("synopsis")
    @Expose
    String synopsis;
    @SerializedName("GENRE")
    @Expose
    List<String> genres;
    @SerializedName("images")
    @Expose
    List<Image> images;
    @SerializedName("trailers")
    @Expose
    List<Video> trailers;
    @SerializedName("songs")
    @Expose
    List<Video> songs;
    @SerializedName("other_videos")
    @Expose
    List<Video> otherVideos;

    @SerializedName("parties")
    @Expose
    Parties parties;

    public Parties getParties() {
        return parties;
    }

    public void setParties(Parties parties) {
        this.parties = parties;
    }

    public class Image{
        @SerializedName("imageUrl")
        @Expose
        public String imageUrl;
    }
    public class Video{
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("value")
        @Expose
        public String value;
    }


    public class Parties{
        @SerializedName("WRITER")
        @Expose
        public List<String> writers;
        @SerializedName("DIRECTOR")
        @Expose
        public List<String> directors;
        @SerializedName("ACTOR")
        @Expose
        public List<String> actors;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefaultImage() {
        return defaultImage;
    }

    public void setDefaultImage(String defaultImage) {
        this.defaultImage = defaultImage;
    }

    public String getDefaultVideo() {
        return defaultVideo;
    }

    public void setDefaultVideo(String defaultVideo) {
        this.defaultVideo = defaultVideo;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Video> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<Video> trailers) {
        this.trailers = trailers;
    }

    public List<Video> getSongs() {
        return songs;
    }

    public void setSongs(List<Video> songs) {
        this.songs = songs;
    }

    public List<Video> getOtherVideos() {
        return otherVideos;
    }

    public void setOtherVideos(List<Video> otherVideos) {
        this.otherVideos = otherVideos;
    }
}
