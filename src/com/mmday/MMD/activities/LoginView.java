package com.mmday.MMD.activities;

public interface LoginView {
    public void showProgress();

    public void hideProgress();

    public void setEmailError();

    public void setPasswordError();

    public void navigateToHome();
}
