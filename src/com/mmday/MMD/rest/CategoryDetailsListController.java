package com.mmday.MMD.rest;

import com.mmday.MMD.models.CategoryDetailsListEntity;
import retrofit.Callback;
import retrofit.http.GET;

public interface CategoryDetailsListController {
    @GET("/Fun/Imagini/Categories")
    void getCategories(Callback<CategoryDetailsListEntity> callback);
}
