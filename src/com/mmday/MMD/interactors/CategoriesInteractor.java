package com.mmday.MMD.interactors;

import com.mmday.MMD.models.CategoryDto;

import java.util.List;

public interface CategoriesInteractor {
    public void load();

    public List<CategoryDto> getCategories();
}
