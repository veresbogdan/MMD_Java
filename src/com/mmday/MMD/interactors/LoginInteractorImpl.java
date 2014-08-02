package com.mmday.MMD.interactors;

import android.text.TextUtils;
import com.mmday.MMD.models.UserDto;
import com.mmday.MMD.presenters.OnLoginFinishedListener;
import com.mmday.MMD.presenters.OnSignUpFinishedListener;
import com.mmday.MMD.services.LoginService;
import com.mmday.MMD.services.LoginServiceImpl;

public class LoginInteractorImpl implements LoginInteractor {

    private LoginService loginService;

    public LoginInteractorImpl() {
        this.loginService = new LoginServiceImpl();
    }

    @Override
    public String loginWithCredentials(final String email, final String password, final OnLoginFinishedListener listener) {
        String token = null;

        boolean error = false;
        if (TextUtils.isEmpty(email)){
            listener.onEmailError();
            error = true;
        }
        if (TextUtils.isEmpty(password)){
            listener.onPasswordError();
            error = true;
        }
        if (!error){
            UserDto response = loginService.loginWithCredentials(email, password);
            token = response.getToken();
        }

        return token;
    }

    @Override
    public String signUpWithCredentials(final String username,final String password,final String email,final String location, final OnSignUpFinishedListener listener) {
        String token = null;

        boolean error = false;
        if (TextUtils.isEmpty(username)){
            listener.onUsernameError();
            error = true;
        }
        if (TextUtils.isEmpty(email)){
            listener.onEmailError();
            error = true;
        }
        if (TextUtils.isEmpty(password)){
            listener.onPasswordError();
            error = true;
        }
        if (!error){
            UserDto response = loginService.signUpWithCredentials(username, password, email, location);
            token = response.getToken();
        }

        return token;
    }

    @Override
    public UserDto loginWithFacebook(String fbToken, String fbUserId) {
        return loginService.loginWithFacebook(fbToken, fbUserId);
    }
}
