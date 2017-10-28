package com.pratishthakapoor.movielisticle.Presenter;

import com.pratishthakapoor.movielisticle.View.LoginView;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

/**
 * Created by Pratishtha on 9/15/2017.
 */
public class LoginPresenterTest {
    @Test
    public void checkIfLoginAttemptIsExceeded() {
        LoginView loginView= Mockito.mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
        Assert.assertEquals(1, loginPresenter.incrementLoginAttempt());
        Assert.assertEquals(2, loginPresenter.incrementLoginAttempt());
        Assert.assertEquals(3, loginPresenter.incrementLoginAttempt());
        Assert.assertTrue(loginPresenter.isLoginAttemptExceeded());
    }


    @Test
    public void checkIfLoginAttemptIsNotExceeded() {
        LoginView loginView= Mockito.mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
        Assert.assertFalse(loginPresenter.isLoginAttemptExceeded());
    }

    @Test
    public void checkUsernameAndPasswordIsCorrect()
    {
        LoginView loginView= Mockito.mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
        loginPresenter.doLogin("admin","admin");
        Mockito.verify(loginView).showLoginSuccessMessage();
    }

    @Test
    public void checkUsernameAndPasswordIsInCorrect()
    {
        LoginView loginView= Mockito.mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
        loginPresenter.doLogin("xyz","tdd");
        Mockito.verify(loginView).showErrorMessageForUserNamePassword();
    }

    @Test
    public void checkIfLoginAttemptIsExceededAndViewMethodCalled()
    {
        LoginView loginView= Mockito.mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
        loginPresenter.doLogin("xyz","tdd");
        loginPresenter.doLogin("xyz","tdd");
        loginPresenter.doLogin("xyz","tdd");
        loginPresenter.doLogin("xyz","tdd");
        Mockito.verify(loginView).showErrorMessageForMaxLoginAttempt();
    }

}