package com.mmday.MMD.presenters;

import com.mmday.MMD.activities.FullScreenImageView;
import com.mmday.MMD.services.ThumbnailImageService;
import com.mmday.MMD.services.ThumbnailImageServiceImpl;

/**
 * Created by albert on 20.07.2014.
 */
public class FullScreenImagePresenterImpl implements FullScreenImagePresenter, OnFinishedListener {
    private final FullScreenImageView view;
    private final ThumbnailImageService service;

    public FullScreenImagePresenterImpl(FullScreenImageView fullScreenImageView) {
        this.view = fullScreenImageView;
        this.service = new ThumbnailImageServiceImpl();
    }

    @Override
    public void load(String imageId) {
        this.service.load(imageId, this);
    }

    @Override
    public void onError() {
        //TODO : show error
    }

    @Override
    public void onSuccess() {
        this.view.loadImage(this.service.getThumbnail());
    }
}
