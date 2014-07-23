package com.mmday.MMD.services;

import com.mmday.MMD.models.ImageDto;
import com.mmday.MMD.presenters.OnFinishedListener;

import java.util.List;

public interface ImagesService {

    public void loadImages(String categoryId, OnFinishedListener onFinishedListener);

    List<ImageDto> getImages();
}
