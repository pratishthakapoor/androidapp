package com.pratishthakapoor.gomovie.ui.movieInfo;

import com.pratishthakapoor.gomovie.ui.base.MvpPresenter;

/**
 * Created by tanmayvijayvargiya on 02/04/17.
 */
public interface MovieInfoPresenter<V extends MovieInfoView> extends MvpPresenter<V> {

    public void setMovieId(String movieId);
}
