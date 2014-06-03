package com.mmday.MMD.services;

import com.mmday.MMD.rest.RetrofitController;
import com.mmday.MMD.rest.UserController;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class LoginServiceImpl implements LoginService {

    @Override
    public void loginWithCredentials(String username, String password) {
        UserController userController = RetrofitController.getInstance().getRestAdapter().create(UserController.class);

        Callback callback = new Callback() {
            @Override
            public void success(Object o, Response response) {
                System.out.println("Logged user: " + response + " and o??: " + o);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                System.out.println("Error: " + retrofitError);
            }
        };

        userController.loginWithCredentials(username, password, callback);
    }
}
