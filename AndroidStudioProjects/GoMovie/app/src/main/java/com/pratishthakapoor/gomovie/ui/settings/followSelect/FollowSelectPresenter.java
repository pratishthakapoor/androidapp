package com.pratishthakapoor.gomovie.ui.settings.followSelect;

import com.pratishthakapoor.gomovie.ui.base.MvpPresenter;

/**
 * Created by tanmayvijayvargiya on 01/04/17.
 */
public interface FollowSelectPresenter<V extends FollowSelectView > extends MvpPresenter<V> {

    public void onUserItemClick(String id, boolean isChecked);
    public void onSkipClick();
    public void onFollowClick();
}
