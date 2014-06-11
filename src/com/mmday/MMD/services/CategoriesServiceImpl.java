package com.mmday.MMD.services;

import com.mmday.MMD.models.CategoryDetailsEntity;
import com.mmday.MMD.models.CategoryDetailsListEntity;
import com.mmday.MMD.rest.CategoryDetailsListController;
import com.mmday.MMD.rest.RetrofitController;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class CategoriesServiceImpl implements CategoriesService {

    private static CategoryDetailsListController categoriesController;

    public CategoriesServiceImpl() {
        categoriesController = RetrofitController.create(CategoryDetailsListController.class);
    }

    //TODO: find a better way to return this value
    @Override
    public void getCategories() {
        categoriesController.getCategories(new Callback<CategoryDetailsListEntity>() {
            @Override
            public void success(CategoryDetailsListEntity categoriesEntity, Response response) {
                System.out.println("Response: " + response.getStatus());

                for (CategoryDetailsEntity categoryDetailsEntity: categoriesEntity.getList()) {
                    System.out.println(categoryDetailsEntity);
                }
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                System.out.println("fuck this shit" + retrofitError.getMessage() + " resp:" + retrofitError.getResponse());
            }
        });
    }
}
