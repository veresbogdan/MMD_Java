package com.mmday.MMD.interactors;

import com.mmday.MMD.presenters.OnLoginFinishedListener;
import com.mmday.MMD.services.LoginService;
import com.mmday.MMD.services.LoginServiceImpl;

public class LoginInteractorImpl implements LoginInteractor {

    private LoginService loginService;

    public LoginInteractorImpl() {
        this.loginService = new LoginServiceImpl();
    }

    @Override
    public void loginWithCredentials(final String username, final String password, final OnLoginFinishedListener listener) {
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                boolean error = false;
//                if (TextUtils.isEmpty(username)){
//                    listener.onUsernameError();
//                    error = true;
//                }
//                if (TextUtils.isEmpty(password)){
//                    listener.onPasswordError();
//                    error = true;
//                }
//                if (!error){
//                    listener.onSuccess();
//                }
//            }
//        }, 2000);
          loginService.loginWithCredentials(username, password);
    }
}
