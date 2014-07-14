package com.mmday.MMD.presenters;

import com.mmday.MMD.activities.SignUpView;
import com.mmday.MMD.interactors.LoginInteractor;
import com.mmday.MMD.interactors.LoginInteractorImpl;

public class SignUpPresenterImpl implements SignUpPresenter, OnSignUpFinishedListener{

    private SignUpView signUpView;
    private LoginInteractor loginInteractor;

    public SignUpPresenterImpl(SignUpView signUpView) {
        this.signUpView = signUpView;
        this.loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void onUsernameError() {
        signUpView.setUpUsernameError();
        signUpView.hideProgress();
    }

    @Override
    public void onEmailError() {
        signUpView.setEmailError();
        signUpView.hideProgress();
    }

    @Override
    public void onPasswordError() {
        signUpView.setPasswordError();
        signUpView.hideProgress();
    }

    @Override
    public void onSuccess() {
        signUpView.navigateToHome();
    }

    @Override
    public String signUpWithCredentials(String username, String password, String email, String location) {
        return loginInteractor.signUpWithCredentials(username, password, email, location, this);
    }

    @Override
    public void showProgress() {
        signUpView.showProgress();
    }
}
