package com.mmday.MMD.rest;

import com.mmday.MMD.models.UserEntity;
import retrofit.http.Body;
import retrofit.http.POST;

public interface UserController {

    @POST("/User/Auth")
    UserEntity loginWithCredentials (@Body UserEntity userEntity);
}
