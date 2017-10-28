package com.pratishthakapoor.gomovie.data.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by tanmayvijayvargiya on 09/04/17.
 */

public class ReviewListResponse {

    @SerializedName("reviews")
    @Expose
    List<ReviewOverview> reviews;

    public List<ReviewOverview> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewOverview> reviews) {
        this.reviews = reviews;
    }
}
