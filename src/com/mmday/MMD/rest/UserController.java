package com.mmday.MMD.rest;

import com.mmday.MMD.models.UserDto;
import retrofit.http.Body;
import retrofit.http.POST;
import retrofit.http.PUT;

import java.util.Map;

public interface UserController {

    @POST("/login")
    UserDto loginWithCredentials (@Body UserDto userDto);        //this one is sync

    @PUT("/user")
    UserDto signUpWithCredentials (@Body UserDto userDto);        //sync also

    @POST("/login/fb")
    UserDto loginWithFacebook (@Body Map<String, String> fbLogin);
}
