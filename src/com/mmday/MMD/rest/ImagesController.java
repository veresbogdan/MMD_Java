package com.mmday.MMD.rest;

import com.mmday.MMD.models.ImageDto;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

import java.util.List;

public interface ImagesController {

    //TODO instead of string category id, maybe we should use directly the long type
    //in this way we don't have to convert it to a string
    @GET("/images/categories/{id}")
    void getImages(@Path("id") String categoryId, Callback<List<ImageDto>> callback);
}
