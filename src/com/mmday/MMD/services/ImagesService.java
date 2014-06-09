package com.mmday.MMD.services;

import com.mmday.MMD.models.CategoryEntity;
import com.mmday.MMD.models.ImageEntity;

public interface ImagesService {
    java.util.Collection<ImageEntity> getImagesFrom(CategoryEntity categoryEntity);
}
