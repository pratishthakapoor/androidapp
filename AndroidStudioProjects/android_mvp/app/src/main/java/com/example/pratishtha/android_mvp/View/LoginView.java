package com.example.pratishtha.android_mvp.View;

/**
 * Created by Pratishtha on 9/8/2017.
 */

public interface LoginView {
    
   /**
   * Show validation Error
   */

    void showValidationError();

    /**
     *Show login Success
     */

    void loginSucess();

    /**
     *  Show Login Error
     */

    void loginError();
}
