package com.mmday.MMD.services;

import com.mmday.MMD.models.CategoryDetailsEntity;
import java.util.Collection;

public interface CategoriesService {
    Collection<CategoryDetailsEntity> getCategories(String token);
}
