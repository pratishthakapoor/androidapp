package com.pratishthakapoor.gomovie.ui.base;

import javax.inject.Inject;

import com.pratishthakapoor.gomovie.data.DataManager;

/**
 * Created by tanmayvijayvargiya on 13/02/17.
 */
public class BasePresenter<V extends MvpView> implements MvpPresenter<V>{

    private final DataManager dataManager;

    private V mvpView;

    @Inject
    public BasePresenter(DataManager dataManager){
        this.dataManager = dataManager;
    }

    @Override
    public void onAttach(V mvpView) {
        this.mvpView = mvpView;
    }

    @Override
    public void onDetach() {
        this.mvpView = null;
    }


    @Override
    public void handleApiError(Object error){

    }

    @Override
    public void setUserAsLoggedOut() {

    }

    public boolean isViewAttached(){
        return mvpView != null;
    }

    public V getMvpView(){
        return mvpView;
    }

    public void checkViewAttached(){
        if(!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    public DataManager getDataManager() {
        return dataManager;
    }

    public static class MvpViewNotAttachedException extends RuntimeException{
        public MvpViewNotAttachedException() {
            super("Please call Presenter.onAttach(MvpView) before"+
                    " requesting data to the Presenter");
        }
    }
}
