package com.mmday.MMD.presenters;

public interface LoginPresenter {
    public String loginWithCredentials(String username, String password);

    public void showProgress();
}
