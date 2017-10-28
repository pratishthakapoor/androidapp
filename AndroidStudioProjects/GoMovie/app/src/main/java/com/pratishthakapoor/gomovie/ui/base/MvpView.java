package com.pratishthakapoor.gomovie.ui.base;

import android.support.annotation.StringRes;

import java.util.List;

import com.pratishthakapoor.gomovie.util.MenuComponent;

/**
 * Created by tanmayvijayvargiya on 13/02/17.
 */
public interface MvpView {
    void showLoading(String text);

    void hideLoading();

    void openActivityOnTokenExpire();

    void onError(@StringRes int resId);

    void onError(String message);

    boolean isNetworkConnected();

    void showMenuOverlay(List<MenuComponent> menuComponents, MenuFragment.MenuCallback callback);
    void hideMenuOverlay();
    void showPhotoOverlay(String url);
    void hidePhotoOverlay();
}
