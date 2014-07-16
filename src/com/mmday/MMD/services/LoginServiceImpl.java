package com.mmday.MMD.services;

import com.mmday.MMD.models.UserDto;
import com.mmday.MMD.rest.RetrofitController;
import com.mmday.MMD.rest.UserController;
public class LoginServiceImpl implements LoginService {

    private static UserController userController;

    public LoginServiceImpl() {
        userController = RetrofitController.create(UserController.class);
    }

    @Override
    public UserDto loginWithCredentials(String email, String password) {
        UserDto userDto = new UserDto();
        userDto.setEmail(email);
        userDto.setPassword(password);

        userDto = userController.loginWithCredentials(userDto);

        return userDto;
    }

    @Override
    public UserDto signUpWithCredentials(String username, String password, String email, String location) {
        UserDto userDto = new UserDto();
        userDto.setUsername(username);
        userDto.setEmail(email);
        userDto.setPassword(password);
        userDto.setLocation(location);

        userDto = userController.signUpWithCredentials(userDto);

        return userDto;
    }
}
