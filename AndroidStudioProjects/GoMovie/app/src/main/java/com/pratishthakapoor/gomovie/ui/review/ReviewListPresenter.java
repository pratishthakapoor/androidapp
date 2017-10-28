package com.pratishthakapoor.gomovie.ui.review;

import com.pratishthakapoor.gomovie.data.network.response.ReviewOverview;
import com.pratishthakapoor.gomovie.ui.base.MvpPresenter;

/**
 * Created by tanmayvijayvargiya on 09/04/17.
 */

public interface ReviewListPresenter<V extends ReviewListView> extends MvpPresenter<V> {
    public void setUserId(String userId);
    public void setMovieId(String movieId);
    public void onReviewClick(ReviewOverview reviewItem);
}
