package com.pratishthakapoor.gomovie.ui.base;

/**
 * Created by tanmayvijayvargiya on 13/02/17.
 */
public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);

    void onDetach();

    void handleApiError(Object error);

    void setUserAsLoggedOut();
}
