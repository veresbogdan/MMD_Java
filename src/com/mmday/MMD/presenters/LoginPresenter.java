package com.mmday.MMD.presenters;

public interface LoginPresenter {
    public String loginWithCredentials(String email, String password);

    public void showProgress();
}
