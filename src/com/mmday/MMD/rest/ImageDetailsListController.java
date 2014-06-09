package com.mmday.MMD.rest;

import com.mmday.MMD.models.CategoryEntity;
import com.mmday.MMD.models.ImageEntity;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;

import java.util.List;

public interface ImageDetailsListController {
    @POST("/Fun/Imagini")
    void getImages(@Body CategoryEntity categoryEntity, Callback<List<ImageEntity>> callback);
}
