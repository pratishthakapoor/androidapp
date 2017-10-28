package com.pratishthakapoor.gomovie.ui.home.search;

import in.co.gomovie.gomovieapp.ui.base.MvpPresenter;
import in.co.gomovie.gomovieapp.ui.base.MvpView;

/**
 * Created by tanmayvijayvargiya on 07/04/17.
 */

public interface SearchPresenter<V extends MvpView> extends MvpPresenter<V> {
    void onSearchValueChange(String searchString);
    void addToRecent(String recent);
}
