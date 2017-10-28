package com.pratishthakapoor.gomovie.ui.home;

import java.util.List;

import in.co.gomovie.gomovieapp.ui.base.MvpPresenter;
import in.co.gomovie.gomovieapp.ui.base.MvpView;
import in.co.gomovie.gomovieapp.util.LanguageComponent;

/**
 * Created by tanmayvijayvargiya on 16/02/17.
 */
public interface HomePresenter<V extends MvpView> extends MvpPresenter<V> {
    void onLanguageSelected(List<LanguageComponent> selectedLanguages);
    void suggestLanguageSelection();
    void showLanguageSelectionFragment();
    void showUserTimelineFragment();
    void showUserFeedFragment();
    void onLogoutRequested();
}
