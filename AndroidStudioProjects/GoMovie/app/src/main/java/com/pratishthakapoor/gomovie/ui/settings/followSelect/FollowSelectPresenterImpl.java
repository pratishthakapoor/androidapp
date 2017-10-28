package com.pratishthakapoor.gomovie.ui.settings.followSelect;

import android.util.Log;

import com.facebook.AccessToken;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.pratishthakapoor.gomovie.data.DataManager;
import com.pratishthakapoor.gomovie.data.network.NetworkResponse;
import com.pratishthakapoor.gomovie.data.network.response.FbFriendsResponse;
import com.pratishthakapoor.gomovie.data.network.response.MovieInfoResponse;
import com.pratishthakapoor.gomovie.ui.base.BasePresenter;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by tanmayvijayvargiya on 01/04/17.
 */
public class FollowSelectPresenterImpl<V extends FollowSelectView> extends BasePresenter<V> implements FollowSelectPresenter<V> {

    @Inject
    public FollowSelectPresenterImpl(DataManager dataManager) {
        super(dataManager);
    }

    List<String> toFollow = new ArrayList<String>();
    List<String> toUnFollow = new ArrayList<String>();
    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
        getMvpView().showLoading("Loading friends list..");
        getDataManager().getFBFriends(getDataManager().getCurrentUserid(), AccessToken.getCurrentAccessToken().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<FbFriendsResponse>>() {
                    @Override
                    public void call(List<FbFriendsResponse> fbFriendsResponses) {
                        getMvpView().hideLoading();
                        getMvpView().setUsers(fbFriendsResponses);
                    }
                });

        getDataManager().movieInfo("10084")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<MovieInfoResponse>() {
                    @Override
                    public void call(MovieInfoResponse movieInfoResponse) {
                        Log.d("MovieInfo", movieInfoResponse.getName());
                        Log.d("MovieInfo", movieInfoResponse.getDefaultImage());
                    }
                });
    }

    @Override
    public void onUserItemClick(String id, boolean isChecked) {
        if(isChecked){
            if(toUnFollow.contains(id))
                toUnFollow.remove(id);
            toFollow.add(id);
        }else{
            if(toFollow.contains(id))
                toFollow.remove(id);
            toUnFollow.add(id);
        }
    }

    @Override
    public void onSkipClick() {
        getMvpView().navigateToHome();
    }

    @Override
    public void onFollowClick() {
        String userId = getDataManager().getCurrentUserid();
        getMvpView().showLoading("Loading..");
        for(String s: toFollow){
            Log.d("follow",s);
        }
        for(String s: toUnFollow){
            Log.d("unFollow",s);
        }
        if(toFollow.size() > 0)
        getDataManager().followMany(userId, toFollow)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<NetworkResponse>() {
                    @Override
                    public void call(NetworkResponse networkResponse) {
                        checkViewAttached();
                        getMvpView().hideLoading();
                        getMvpView().navigateToHome();
                    }
                });
        if(toUnFollow.size() > 0)
        getDataManager().unFollowMany(userId, toUnFollow)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<NetworkResponse>() {
                    @Override
                    public void call(NetworkResponse networkResponse) {
                        checkViewAttached();
                        getMvpView().hideLoading();
                        getMvpView().navigateToHome();
                    }
                });
    }
}
