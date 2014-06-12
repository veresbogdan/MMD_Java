package com.mmday.MMD.rest;

import com.mmday.MMD.models.UserDto;
import retrofit.http.Body;
import retrofit.http.POST;

public interface UserController {

    @POST("/User/Auth")
    UserDto loginWithCredentials (@Body UserDto userDto);        //this one is sync
}
