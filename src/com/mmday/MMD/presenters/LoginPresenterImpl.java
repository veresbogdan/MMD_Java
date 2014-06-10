package com.mmday.MMD.presenters;

import com.mmday.MMD.activities.LoginView;
import com.mmday.MMD.interactors.LoginInteractor;
import com.mmday.MMD.interactors.LoginInteractorImpl;

public class LoginPresenterImpl implements LoginPresenter, OnLoginFinishedListener {

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
    }

    @Override public String loginWithCredentials(String username, String password) {
        return loginInteractor.loginWithCredentials(username, password, this);
    }

    @Override public void onUsernameError() {
        loginView.setUsernameError();
        loginView.hideProgress();
    }

    @Override public void onPasswordError() {
        loginView.setPasswordError();
        loginView.hideProgress();
    }

    @Override public void onSuccess() {
        loginView.navigateToHome();
    }

    @Override
    public void showProgress() {
        loginView.showProgress();
    }
}
