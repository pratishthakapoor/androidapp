package com.pratishthakapoor.gomovie.ui.home.account;

import com.pratishthakapoor.gomovie.ui.base.MvpPresenter;

/**
 * Created by tanmayvijayvargiya on 01/04/17.
 */
public interface AccountPresenter<V extends AccountView> extends MvpPresenter<V> {


    void setUserId(String userId);
}
