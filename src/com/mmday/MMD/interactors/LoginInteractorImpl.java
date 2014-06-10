package com.mmday.MMD.interactors;

import android.text.TextUtils;
import com.mmday.MMD.presenters.OnLoginFinishedListener;
import com.mmday.MMD.services.LoginService;
import com.mmday.MMD.services.LoginServiceImpl;

public class LoginInteractorImpl implements LoginInteractor {

    private LoginService loginService;

    public LoginInteractorImpl() {
        this.loginService = new LoginServiceImpl();
    }

    @Override
    public String loginWithCredentials(final String username, final String password, final OnLoginFinishedListener listener) {
        String token = null;

        boolean error = false;
        if (TextUtils.isEmpty(username)){
            listener.onUsernameError();
            error = true;
        }
        if (TextUtils.isEmpty(password)){
            listener.onPasswordError();
            error = true;
        }
        if (!error){
            token = loginService.loginWithCredentials(username, password);
            listener.onSuccess();
        }

        return token;
    }
}
