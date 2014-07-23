package com.mmday.MMD.interactors;

import com.mmday.MMD.models.ImageDto;

import java.util.List;

public interface ImagesInteractor {

    public void load(String categoryId);

    public List<ImageDto> getImages();
}
