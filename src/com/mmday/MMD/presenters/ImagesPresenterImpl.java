package com.mmday.MMD.presenters;

import com.mmday.MMD.activities.arc.ImagesView;
import com.mmday.MMD.interactors.ImagesInteractor;
import com.mmday.MMD.interactors.ImagesInteractorImpl;

public class ImagesPresenterImpl implements ImagesPresenter, OnFinishedListener {
    private final String categoryId;
    private ImagesView view;
    private ImagesInteractor interactor;

    public ImagesPresenterImpl(ImagesView imagesView, String category) {
        view = imagesView;
        categoryId = category;
        interactor = new ImagesInteractorImpl(this);
    }

    @Override
    public void load() {
        interactor.load(categoryId);
    }

    @Override
    public void onError() {
        //show error
    }

    @Override
    public void onSuccess() {
        view.updateImages(this.interactor.getImages());
    }
}
