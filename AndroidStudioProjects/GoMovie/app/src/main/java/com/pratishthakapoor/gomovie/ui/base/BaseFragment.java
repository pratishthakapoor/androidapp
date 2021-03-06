package com.pratishthakapoor.gomovie.ui.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;

import java.util.List;

import com.pratishthakapoor.gomovie.di.component.ActivityComponent;
import com.pratishthakapoor.gomovie.util.MenuComponent;

/**
 * Created by tanmayvijayvargiya on 13/02/17.
 */
public class BaseFragment extends Fragment implements MvpView{

    private BaseActivity activity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof BaseActivity){
            BaseActivity activity = (BaseActivity) context;
            this.activity = activity;
            activity.onFragmentAttached();
        }
    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        if(context instanceof BaseActivity){
            BaseActivity activity = (BaseActivity) context;
            this.activity = activity;
            activity.onFragmentAttached();
        }
    }

    @Override
    public void showLoading(String text) {
        if(activity != null){
            activity.showLoading(text);
        }
    }

    @Override
    public void hideLoading() {
        if(activity != null){
            activity.hideLoading();
        }

    }

    @Override
    public void openActivityOnTokenExpire() {
        if(activity != null){
            activity.openActivityOnTokenExpire();
        }
    }

    @Override
    public void onError(@StringRes int resId) {
        if(activity != null){
            activity.onError(resId);
        }
    }

    @Override
    public void onError(String message) {
        if(activity != null){
            activity.onError(message);
        }
    }

    @Override
    public boolean isNetworkConnected() {
        if(activity != null){
            return activity.isNetworkConnected();
        }
        return false;
    }

    @Override
    public void showMenuOverlay(List<MenuComponent> menuComponents, MenuFragment.MenuCallback callback) {
        activity.showMenuOverlay(menuComponents, callback);
    }

    @Override
    public void hideMenuOverlay() {
        activity.hideMenuOverlay();
    }

    @Override
    public void showPhotoOverlay(String url) {
        activity.showPhotoOverlay(url);
    }

    @Override
    public void hidePhotoOverlay() {

    }

    @Override
    public void onDetach() {
        this.activity = null;
        super.onDetach();
    }

    public ActivityComponent getActivityComponent(){
        return activity.getActivityComponent();
    }

    public BaseActivity getBaseAcitivity(){
        return activity;
    }

    public interface Callback{
        void onFragmentAttached();

        void onFragmentDetached(String tag);
    }
}
