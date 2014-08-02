package com.mmday.MMD.presenters;

import com.mmday.MMD.interactors.LoginInteractor;
import com.mmday.MMD.interactors.LoginInteractorImpl;
import com.mmday.MMD.models.UserDto;

public class FbLoginPresenterImpl implements FbLoginPresenter {

    private LoginInteractor loginInteractor;

    public FbLoginPresenterImpl() {
        loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public UserDto loginWithFacebook(String fbToken, String fbUserID) {
        return loginInteractor.loginWithFacebook(fbToken, fbUserID);
    }
}
