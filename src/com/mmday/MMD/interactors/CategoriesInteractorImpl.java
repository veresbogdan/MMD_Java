package com.mmday.MMD.interactors;

import com.mmday.MMD.models.CategoryDto;
import com.mmday.MMD.presenters.OnFinishedListener;
import com.mmday.MMD.services.CategoriesService;
import com.mmday.MMD.services.CategoriesServiceImpl;

import java.util.List;

/**
 * Created by albert on 20.07.2014.
 */
public class CategoriesInteractorImpl implements CategoriesInteractor {
    private final OnFinishedListener onFinishedListener;
    private CategoriesService categoriesService;

    public CategoriesInteractorImpl(OnFinishedListener listener) {
        this.categoriesService = new CategoriesServiceImpl();
        this.onFinishedListener = listener;
    }

    @Override
    public void load() {
        this.categoriesService.loadCategories(this.onFinishedListener);
    }

    @Override
    public List<CategoryDto> getCategories() {
        return this.categoriesService.getCategories();
    }
}
