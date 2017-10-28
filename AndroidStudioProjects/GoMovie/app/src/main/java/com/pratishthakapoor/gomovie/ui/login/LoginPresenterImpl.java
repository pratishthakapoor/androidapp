package com.pratishthakapoor.gomovie.ui.login;

import android.os.Bundle;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;

import org.json.JSONException;
import org.json.JSONObject;

import javax.inject.Inject;

import com.pratishthakapoor.gomovie.data.DataManager;
import com.pratishthakapoor.gomovie.data.network.response.LoginResponse;
import com.pratishthakapoor.gomovie.ui.base.BasePresenter;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by tanmayvijayvargiya on 16/02/17.
 */
public class LoginPresenterImpl<V extends LoginView> extends BasePresenter<V> implements LoginPresenter<V>,
        FacebookCallback<LoginResult>, GraphRequest.GraphJSONObjectCallback{

    private static String TAG = "Login Presenter";
    public String accessToken = "";

    @Inject
    public LoginPresenterImpl(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void onAttach(V mvpView) {
        Log.d(TAG, "On Attached Called!");
        super.onAttach(mvpView);
        try{
            checkViewAttached();
            getMvpView().checkGooglePlayServices();
            checkAlreadyLoggedIn();
            getMvpView().registerFacebookCallbackResult(this);
        }catch (MvpViewNotAttachedException e){
            e.printStackTrace();
        }

        String userId = getDataManager().getCurrentUserid();
        if(userId != null){
            getMvpView().onError(userId);
        }
    }

    @Override
    public void onSuccess(LoginResult loginResult) {
        Log.d(TAG,"SUCCESSFULLY LOGGED IN!");
        Log.d(TAG,"Access: " + loginResult.getAccessToken().getToken());
        this.accessToken = loginResult.getAccessToken().getToken();
        GraphRequest request = GraphRequest.newMeRequest(
                loginResult.getAccessToken(),this);
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,email");
        request.setParameters(parameters);
        request.executeAsync();
        getMvpView().showLoading("Fetching User Information");
    }

    @Override
    public void onCancel() {

    }

    @Override
    public void onError(FacebookException error) {

    }

    @Override
    public void onSlideClicked(int position) {
        switch (position){
            case 2 :
                getMvpView().initiateFbLogin();
                break;
        }
    }

    @Override
    public void onNextClick(int position) {
        if(position != 2){
            getMvpView().showNextSlide();
        }
    }

    @Override
    public void onSkipClick() {
        checkAlreadyLoggedIn();
    }

    @Override
    public void onCompleted(JSONObject object, GraphResponse response) {
        // Application code
        try {
            String name = object.getString("name");
            getMvpView().showLoading("Logging In " + name );

            if(!object.has("email")){
                getMvpView().showLoading("Email Not Found!");
                return;
            }
            String email = object.getString("email");

            String id = object.getString("id");
            Log.d(TAG,"id: " + id);
            getDataManager().setCurrentUserId(id);
            getMvpView().showLoading(id);
            getDataManager().setCurrentUserName(name);
            getDataManager().login(id,name, accessToken, email)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<LoginResponse>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            getMvpView().showLoading(e.getMessage());
                            Log.d("LoginPresenter", e.getMessage());
                        }

                        @Override
                        public void onNext(LoginResponse loginResponse) {
                            getMvpView().hideLoading();
                            Log.d("LoginPresenter", loginResponse.getMessage());
                            getDataManager().setSessionId(loginResponse.getSessionId());
                            checkAlreadyLoggedIn();
                        }
                    });

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void checkAlreadyLoggedIn() {

        String userId = getDataManager().getCurrentUserid();
        String sessionId = getDataManager().getSessionId();
        AccessToken accessToken = AccessToken.getCurrentAccessToken();


        if(userId != null && sessionId != null && accessToken != null){
            getMvpView().openHomeActivity();
        }
    }
}
