package com.pratishthakapoor.gomovie.ui.movieInfo;

import javax.inject.Inject;

import com.pratishthakapoor.gomovie.data.DataManager;
import com.pratishthakapoor.gomovie.data.network.response.MovieInfoResponse;
import com.pratishthakapoor.gomovie.ui.base.BasePresenter;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by tanmayvijayvargiya on 02/04/17.
 */
public class MovieInfoPresenterImpl<V extends MovieInfoView> extends BasePresenter<V>
        implements MovieInfoPresenter<V> {

    private String movieId;
    @Inject
    public MovieInfoPresenterImpl(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void setMovieId(String movieId) {
        this.movieId = movieId;
        getDataManager().movieInfo(movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorReturn(new Func1<Throwable, MovieInfoResponse>() {
                    @Override
                    public MovieInfoResponse call(Throwable throwable) {
                        return null;
                    }
                })
                .subscribe(new Action1<MovieInfoResponse>() {
                    @Override
                    public void call(MovieInfoResponse movieInfoResponse) {
                        getMvpView().setMovieInfo(movieInfoResponse);
                    }
                });
    }
}
