package com.mmday.MMD.interactors;

import com.mmday.MMD.models.ImageDto;
import com.mmday.MMD.presenters.OnFinishedListener;
import com.mmday.MMD.services.ImagesService;
import com.mmday.MMD.services.ImagesServiceImpl;

import java.util.List;

public class ImagesInteractorImpl implements ImagesInteractor {
    private final OnFinishedListener listener;
    private ImagesService imagesService;

    public ImagesInteractorImpl(OnFinishedListener listener) {
        this.listener = listener;
        this.imagesService = new ImagesServiceImpl();
    }

    @Override
    public void load(String categoryId) {
        this.imagesService.loadImages(categoryId, this.listener);
    }

    @Override
    public List<ImageDto> getImages() {
        return this.imagesService.getImages();
    }
}
