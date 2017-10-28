package com.pratishthakapoor.gomovie.data.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by tanmayvijayvargiya on 09/04/17.
 */

public class SingleReviewReponse {
    @SerializedName("review")
    @Expose
    ReviewOverview review;

    public ReviewOverview getReview() {
        return review;
    }

    public void setReview(ReviewOverview review) {
        this.review = review;
    }
}
