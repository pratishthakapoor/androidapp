package com.example.pratishtha.android_mvp.Presenter;

import android.text.TextUtils;

import com.example.pratishtha.android_mvp.View.LoginView;

/**
 * Created by Pratishtha on 9/8/2017.
 */

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView loginView;

    public LoginPresenterImpl(LoginView loginView)
    {
        this.loginView = loginView;
    }

    @Override
    /**
     * Implemetation for the Login Presenter method login(username, password)
     */

    public void login(String username, String password) {
         if(TextUtils.isEmpty(username) && TextUtils.isEmpty(password))
         {
             loginView.showValidationError();
         }
        else
         {
             if(username.equals("admin") && password.equals("pass"))
             {
                 loginView.loginSucess();
             }
             else
                 loginView.loginError();
         }
    }
}
