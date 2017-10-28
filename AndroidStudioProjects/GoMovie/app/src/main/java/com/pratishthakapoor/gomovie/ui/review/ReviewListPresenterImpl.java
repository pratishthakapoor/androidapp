package com.pratishthakapoor.gomovie.ui.review;

import javax.inject.Inject;

import in.co.gomovie.gomovieapp.data.DataManager;
import in.co.gomovie.gomovieapp.data.network.response.ReviewOverview;
import in.co.gomovie.gomovieapp.ui.base.BasePresenter;

/**
 * Created by tanmayvijayvargiya on 09/04/17.
 */

public class ReviewListPresenterImpl<V extends ReviewListView> extends BasePresenter<V> implements ReviewListPresenter<V> {

    String userId, movieId;
    @Inject
    public ReviewListPresenterImpl(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    @Override
    public void onReviewClick(ReviewOverview reviewItem) {

    }
}
