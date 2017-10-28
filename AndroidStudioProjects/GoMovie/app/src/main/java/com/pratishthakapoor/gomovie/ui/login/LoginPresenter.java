package com.pratishthakapoor.gomovie.ui.login;

import com.pratishthakapoor.gomovie.ui.base.MvpPresenter;

/**
 * Created by tanmayvijayvargiya on 13/02/17.
 */
public interface LoginPresenter<V extends LoginView> extends MvpPresenter<V> {
    void onSlideClicked(int position);
    void onNextClick(int position);
    void onSkipClick();
}
