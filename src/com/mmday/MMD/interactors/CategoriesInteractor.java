package com.mmday.MMD.interactors;

import com.mmday.MMD.models.CategoryDto;

import java.util.List;

/**
 * Created by albert on 20.07.2014.
 */
public interface CategoriesInteractor {
    void load();

    List<CategoryDto> getCategories();
}
