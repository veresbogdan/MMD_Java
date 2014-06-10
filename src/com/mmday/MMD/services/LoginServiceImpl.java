package com.mmday.MMD.services;

import com.mmday.MMD.models.UserEntity;
import com.mmday.MMD.rest.RetrofitController;
import com.mmday.MMD.rest.UserController;
public class LoginServiceImpl implements LoginService {

    @Override
    public String loginWithCredentials(String username, String password) {
        UserController userController = RetrofitController.create(UserController.class);

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword(password);

        userEntity = userController.loginWithCredentials(userEntity);

        return userEntity.getToken();

    }
}
