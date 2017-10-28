
package com.pratishthakapoor.gomovie.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FeedGroup {

    @SerializedName("activities")
    @Expose
    private List<Feed> feeds;

    @SerializedName("activity_count")
    @Expose
    private int feedCount;
    @SerializedName("actor_count")
    @Expose
    private int actor_count;

    @SerializedName("verb")
    @Expose
    private String verb;

    @SerializedName("id")
    @Expose
    private String id;

    public List<Feed> getFeeds() {
        return feeds;
    }

    public void setFeeds(List<Feed> feeds) {
        this.feeds = feeds;
    }

    public int getFeedCount() {
        return feedCount;
    }

    public void setFeedCount(int feedCount) {
        this.feedCount = feedCount;
    }

    public int getActor_count() {
        return actor_count;
    }

    public void setActor_count(int actor_count) {
        this.actor_count = actor_count;
    }

    public String getVerb() {
        return verb;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
