package com.mmday.MMD.interactors;

import com.mmday.MMD.presenters.OnLoginFinishedListener;

public interface LoginInteractor {
    public String loginWithCredentials(String username, String password, OnLoginFinishedListener listener);
}
