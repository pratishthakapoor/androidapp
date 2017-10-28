package com.pratishthakapoor.gomovie.ui.comment;

import java.util.List;

import javax.inject.Inject;

import com.pratishthakapoor.gomovie.data.DataManager;
import com.pratishthakapoor.gomovie.data.network.NetworkResponse;
import com.pratishthakapoor.gomovie.model.Comment;
import com.pratishthakapoor.gomovie.ui.base.BasePresenter;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by tanmayvijayvargiya on 15/06/17.
 */

public class CommentPresenterImpl<V extends CommentView> extends BasePresenter<V> implements CommentPresenter<V> {

    CommentView view;
    @Inject
    public CommentPresenterImpl(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void publishComment(String comment) {
        getMvpView().showLoading("Posting comment");
        getDataManager().commentOnActivity(getDataManager().getCurrentUserid(),
                getMvpView().getForeignId(), comment)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<NetworkResponse>() {
                    @Override
                    public void onCompleted() {
                        getMvpView().hideLoading();
                        //getComments();
                        getMvpView().onPublish();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(NetworkResponse networkResponse) {

                    }
                });


    }

    public void getComments() {
        getDataManager().getActivityComments(getDataManager().getCurrentUserid(),
                getMvpView().getForeignId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Comment>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<Comment> comments) {
                        getMvpView().addComment(comments);
                    }
                });
    }

    @Override
    public void endOfListReached() {

    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
        getComments();
    }

}

