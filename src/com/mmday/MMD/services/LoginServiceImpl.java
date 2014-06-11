package com.mmday.MMD.services;

import com.mmday.MMD.models.UserDto;
import com.mmday.MMD.rest.RetrofitController;
import com.mmday.MMD.rest.UserController;
public class LoginServiceImpl implements LoginService {

    private static  UserController userController;

    public LoginServiceImpl() {
        userController = RetrofitController.create(UserController.class);
    }

    @Override
    public String loginWithCredentials(String username, String password) {
        UserDto userDto = new UserDto();
        userDto.setUsername(username);
        userDto.setPassword(password);

        userDto = userController.loginWithCredentials(userDto);

        return userDto.getToken();
    }
}
