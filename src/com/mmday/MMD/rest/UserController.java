package com.mmday.MMD.rest;

import com.mmday.MMD.models.UserEntity;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;

public interface UserController {

    @POST("/User/Auth")
    void loginWithCredentials (@Body UserEntity userEntity, Callback<UserEntity> callback);
}
