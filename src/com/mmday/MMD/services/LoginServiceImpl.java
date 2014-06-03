package com.mmday.MMD.services;

import com.mmday.MMD.models.UserEntity;
import com.mmday.MMD.rest.RetrofitController;
import com.mmday.MMD.rest.UserController;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class LoginServiceImpl implements LoginService {

    @Override
    public void loginWithCredentials(String username, String password) {
        UserController userController = RetrofitController.getInstance().getRestAdapter().create(UserController.class);

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword(password);

        userController.loginWithCredentials(userEntity, new Callback<UserEntity>() {
            @Override
            public void success(UserEntity userEntity, Response response) {
                System.out.println("Response: " + response.getStatus() + " and user: " + userEntity);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                System.out.println("Error: " + retrofitError);
            }
        });
    }
}
