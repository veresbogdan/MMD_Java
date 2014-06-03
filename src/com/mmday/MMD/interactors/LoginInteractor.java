package com.mmday.MMD.interactors;

import com.mmday.MMD.presenters.OnLoginFinishedListener;

public interface LoginInteractor {
    public void loginWithCredentials(String username, String password, OnLoginFinishedListener listener);
}
