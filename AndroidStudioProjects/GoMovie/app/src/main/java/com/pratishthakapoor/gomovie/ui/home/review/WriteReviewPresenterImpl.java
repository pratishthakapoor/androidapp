package com.pratishthakapoor.gomovie.ui.home.review;

import android.util.Log;

import javax.inject.Inject;

import in.co.gomovie.gomovieapp.data.DataManager;
import in.co.gomovie.gomovieapp.data.network.NetworkResponse;
import in.co.gomovie.gomovieapp.ui.base.BasePresenter;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by tanmayvijayvargiya on 08/04/17.
 */

public class WriteReviewPresenterImpl<V extends WriteReviewView> extends BasePresenter<V>
implements WriteReviewPresenter<V>{

    String movieId;
    String movieReview;
    float movieRating;
    @Inject
    public WriteReviewPresenterImpl(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void onPublishRequest() {
        Log.d("ReviewInside", movieId);
        Log.d("ReviewInside", movieReview);
        Log.d("ReviewInside", movieRating + "");

        getMvpView().showLoading("Publishing");
        getDataManager().createMovieReview(getDataManager().getCurrentUserid(),
                getDataManager().getSessionId(),
                movieId, movieReview, movieRating)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NetworkResponse>() {
                    @Override
                    public void onCompleted() {
                        getMvpView().hideLoading();
                        getMvpView().exit();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("error", e.getMessage());
                    }

                    @Override
                    public void onNext(NetworkResponse networkResponse) {
                        Log.d("Success", "success");
                    }
                });
    }

    @Override
    public void onRatingChange(float rating) {
        this.movieRating = rating;
    }

    @Override
    public void onReviewChange(String review) {
        this.movieReview = review;
    }

    @Override
    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
}
