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

    @Override public String loginWithCredentials(String email, String password) {
        return loginInteractor.loginWithCredentials(email, password, this);
    }

    @Override public void onEmailError() {
        loginView.setEmailError();
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
