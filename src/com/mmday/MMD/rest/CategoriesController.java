package com.mmday.MMD.rest;

import com.mmday.MMD.models.CategoryDto;
import retrofit.Callback;
import retrofit.http.GET;

import java.util.List;

public interface CategoriesController {

    @GET("/categories")
    void getCategories(Callback<List<CategoryDto>> callback);
}
