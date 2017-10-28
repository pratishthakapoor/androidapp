package com.pratishthakapoor.gomovie.ui.login;

import com.facebook.FacebookCallback;
import com.facebook.login.LoginResult;

import com.pratishthakapoor.gomovie.ui.base.MvpView;

/**
 * Created by tanmayvijayvargiya on 13/02/17.
 */
public interface LoginView extends MvpView{
    int getCurrentSlideIndex();
    void gotoSlide(int index);
    void showNextSlide();
    void openHomeActivity();
    void initiateFbLogin();
    void checkGooglePlayServices();
    void registerFacebookCallbackResult(FacebookCallback<LoginResult> loginResultFacebookCallback);
}
