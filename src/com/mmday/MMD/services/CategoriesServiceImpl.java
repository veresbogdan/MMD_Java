package com.mmday.MMD.services;

import com.mmday.MMD.models.CategoryDto;
import com.mmday.MMD.presenters.OnFinishedListener;
import com.mmday.MMD.rest.CategoriesController;
import com.mmday.MMD.rest.RetrofitController;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import java.util.ArrayList;
import java.util.List;

public class CategoriesServiceImpl implements CategoriesService {

    private static CategoriesController categoriesController;
    private final List<CategoryDto> categories = new ArrayList<CategoryDto>();

    public CategoriesServiceImpl() {
        this.categoriesController = RetrofitController.create(CategoriesController.class);
    }

    @Override
    public void loadCategories(final OnFinishedListener listener) {
        //TODO: maybe move the listener into the constructor

        categories.clear();

        this.categoriesController.getCategories(new Callback<List<CategoryDto>>() {
            @Override
            public void success(List<CategoryDto> categoriesResp, Response response) {
                System.out.println("Response: " + response.getStatus());

                for (CategoryDto categoryDetailsEntity : categoriesResp) {
                    System.out.println(categoryDetailsEntity);
                }

                categories.addAll(categoriesResp);
                listener.onSuccess();
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                System.out.println("fuck this shit" + retrofitError.getMessage() +
                        " resp:" + retrofitError.getResponse());
                listener.onError();
            }
        });
    }

    @Override
    public List<CategoryDto> getCategories() {
        return this.categories;
    }
}
