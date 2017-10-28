package com.pratishthakapoor.gomovie.ui.home.account;


import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import com.pratishthakapoor.gomovie.data.DataManager;
import com.pratishthakapoor.gomovie.data.network.response.ReviewListResponse;
import com.pratishthakapoor.gomovie.data.network.response.ReviewOverview;
import com.pratishthakapoor.gomovie.data.network.response.UserInfoResponse;
import com.pratishthakapoor.gomovie.model.MovieOverview;
import com.pratishthakapoor.gomovie.model.MovieStat;
import com.pratishthakapoor.gomovie.ui.base.BasePresenter;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by tanmayvijayvargiya on 01/04/17.
 */
public class AccountPresenterImpl<V extends AccountView> extends BasePresenter<V> implements AccountPresenter<V> {

    String userId;
    @Inject
    public AccountPresenterImpl(DataManager dataManager) {

        super(dataManager);
        Log.d("Account","Account Presenter Created!");
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
        String userId;
        if(this.userId != null && this.userId != ""){
            userId = this.userId;
        }else{
            userId = getDataManager().getCurrentUserid();
        }

        getDataManager().getUserInfo(getDataManager().getSessionId(), userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<UserInfoResponse>() {
                    @Override
                    public void call(UserInfoResponse userInfoResponse) {
                        checkViewAttached();
                        getMvpView().setUserInfo(userInfoResponse);
                        if(userInfoResponse != null){
                            if(userInfoResponse.getWishList() != null){
                                for(MovieOverview wishMovieOverview : userInfoResponse.getWishList()){
                                    MovieStat movieStat = new MovieStat(wishMovieOverview.getMovieId());
                                    movieStat.setInWantToWatchList(true);
                                    movieStat.save();
                                }
                            }
                            if(userInfoResponse.getSeenList() != null){
                                for(MovieOverview seenMovieOverview : userInfoResponse.getSeenList()){
                                    MovieStat movieStat = new MovieStat(seenMovieOverview.getMovieId());
                                    movieStat.setInSeenList(true);
                                    movieStat.save();
                                }
                            }
                        }

                    }
                });

        getDataManager().getReviewsOfUser(userId,0,3)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ReviewListResponse>() {
                    @Override
                    public void onCompleted() {
                        Log.d("review", "Request Complete!");
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(ReviewListResponse reviewListResponse) {
                        Log.d("review", "Response recieved!");

                        if(reviewListResponse != null){
                            Log.d("review", "Response size! " + reviewListResponse.getReviews().size());

                            List<ReviewOverview> reviews = reviewListResponse.getReviews();
                            if(reviews != null){
                                getMvpView().setReviews(reviews);
                            }
                        }else{
                            Log.d("review", "Response Null ");
                        }
                    }
                });

    }

    @Override
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
