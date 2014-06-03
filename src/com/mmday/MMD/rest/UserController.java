package com.mmday.MMD.rest;

import com.mmday.MMD.models.UserEntity;
import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

public interface UserController {

    @FormUrlEncoded
    @POST("/User/Auth")
    void loginWithCredentials (@Field("NICKNAME") String username, @Field("PASSWORD") String password, Callback<UserEntity> callback);
}
