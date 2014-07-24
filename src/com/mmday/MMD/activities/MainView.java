package com.mmday.MMD.activities;

import com.mmday.MMD.models.CategoryDto;

import java.util.List;

public interface MainView {
    public void showProgress();

    public void hideProgress();

    public void setCategories(List<CategoryDto> categories);
}
