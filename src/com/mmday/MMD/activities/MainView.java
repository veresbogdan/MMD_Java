package com.mmday.MMD.activities;

import com.mmday.MMD.models.CategoryDto;

import java.util.List;

/**
 * Created by albert on 20.07.2014.
 */
public interface MainView {
    void showProgress();

    void hideProgress();

    void setCategories(List<CategoryDto> categories);
}
