package com.mmday.MMD.interactors;

import com.mmday.MMD.presenters.OnLoginFinishedListener;
import com.mmday.MMD.presenters.OnSignUpFinishedListener;

public interface LoginInteractor {
    public String loginWithCredentials(String email, String password, OnLoginFinishedListener listener);

    public String signUpWithCredentials(String username, String password, String email, String location ,OnSignUpFinishedListener listener);
}
