package com.pratishthakapoor.gomovie.ui.home.review;

import in.co.gomovie.gomovieapp.ui.base.MvpPresenter;

/**
 * Created by tanmayvijayvargiya on 08/04/17.
 */

public interface WriteReviewPresenter<V extends WriteReviewView> extends MvpPresenter<V> {
    void onPublishRequest();
    void onRatingChange(float rating);
    void onReviewChange(String review);
    void setMovieId(String movieId);
}
