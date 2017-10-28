package com.pratishthakapoor.gomovie.ui.home;

import java.util.List;

import in.co.gomovie.gomovieapp.ui.base.MvpView;
import in.co.gomovie.gomovieapp.util.LanguageComponent;

/**
 * Created by tanmayvijayvargiya on 16/02/17.
 */
public interface HomeView extends MvpView {
    void performLanguageSelection(List<LanguageComponent> languageComponents);
    void showUserTimeline();
    void openLoginActivity();
}
