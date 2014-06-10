package com.mmday.MMD.services;

import com.mmday.MMD.models.CategoryDetailsEntity;
import com.mmday.MMD.models.CategoryDetailsListEntity;
import com.mmday.MMD.rest.CategoryDetailsListController;
import com.mmday.MMD.rest.RetrofitController;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CategoriesServiceImpl implements CategoriesService{
    @Override
    public Collection<CategoryDetailsEntity> getCategories(String token) {
        //TODO: find a better solution to pass the token here
        CategoryDetailsListController categoriesController;
        categoriesController = RetrofitController.create(CategoryDetailsListController.class);

        final Collection<CategoryDetailsEntity> result;
        result = new ArrayList<CategoryDetailsEntity>();

        categoriesController.getCategories(new Callback<CategoryDetailsListEntity>() {
            @Override
            public void success(CategoryDetailsListEntity categoriesEntity, Response response) {
                System.out.println("Response: " + response.getStatus());
                Iterator<CategoryDetailsEntity> it = categoriesEntity.getList().iterator();
                while (it.hasNext())
                {
                    CategoryDetailsEntity category = it.next();
                    System.out.println(category.toString());
                }

                //TODO: find a better way to return this value
                result.addAll(categoriesEntity.getList());
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                System.out.println("fuck this shit");
            }
        });

        return result;
    }
}
