package com.mmday.MMD.rest;

import com.mmday.MMD.models.CategoryDto;
import com.mmday.MMD.models.ImageDto;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;

import java.util.List;

public interface ImageDetailsListController {

    @POST("/Fun/Imagini")
    void getImages(@Body CategoryDto categoryDto, Callback<List<ImageDto>> callback);
}
