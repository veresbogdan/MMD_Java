package com.mmday.MMD.presenters;

public interface SignUpPresenter {
    public String signUpWithCredentials(String username, String password, String email, String location);

    public void showProgress();
}
