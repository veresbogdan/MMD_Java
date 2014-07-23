package com.mmday.MMD.services;

import com.mmday.MMD.models.CategoryDto;
import com.mmday.MMD.presenters.OnFinishedListener;

import java.util.List;

public interface CategoriesService {

    public void loadCategories(OnFinishedListener listener);

    public List<CategoryDto> getCategories();
}
