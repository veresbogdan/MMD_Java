package com.mmday.MMD.presenters;

import com.mmday.MMD.activities.FullScreenImageView;
import com.mmday.MMD.services.ThumbnailImageService;
import com.mmday.MMD.services.ThumbnailImageServiceImpl;

public class FullScreenImagePresenterImpl implements FullScreenImagePresenter, OnFinishedListener {
    private final FullScreenImageView view;
    private final ThumbnailImageService service;

    public FullScreenImagePresenterImpl(FullScreenImageView fullScreenImageView) {
        view = fullScreenImageView;
        service = new ThumbnailImageServiceImpl();
    }

    @Override
    public void load(String imageId) {
        service.load(imageId, this);
    }

    @Override
    public void onError() {
        //TODO : show error
    }

    @Override
    public void onSuccess() {
        view.loadImage(this.service.getThumbnail());
    }
}
