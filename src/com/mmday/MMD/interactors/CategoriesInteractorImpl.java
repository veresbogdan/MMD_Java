package com.mmday.MMD.interactors;

import com.mmday.MMD.models.CategoryDto;
import com.mmday.MMD.presenters.OnFinishedListener;
import com.mmday.MMD.services.CategoriesService;
import com.mmday.MMD.services.CategoriesServiceImpl;

import java.util.List;

public class CategoriesInteractorImpl implements CategoriesInteractor {
    private final OnFinishedListener onFinishedListener;
    private CategoriesService categoriesService;

    public CategoriesInteractorImpl(OnFinishedListener listener) {
        categoriesService = new CategoriesServiceImpl();
        onFinishedListener = listener;
    }

    @Override
    public void load() {
        categoriesService.loadCategories(onFinishedListener);
    }

    @Override
    public List<CategoryDto> getCategories() {
        return categoriesService.getCategories();
    }
}
