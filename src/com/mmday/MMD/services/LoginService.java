package com.mmday.MMD.services;

import com.mmday.MMD.models.UserDto;

public interface LoginService {

    public UserDto loginWithCredentials(String email, String password);

    public UserDto signUpWithCredentials(String username, String password, String email, String location);

    public UserDto loginWithFacebook(String fbToken, String fbUserId);
}
