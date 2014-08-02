package com.mmday.MMD.presenters;

import com.mmday.MMD.models.UserDto;

public interface FbLoginPresenter {
    public UserDto loginWithFacebook(String fbToken, String fbUserID);
}
