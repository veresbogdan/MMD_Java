package com.mmday.MMD.presenters;

import com.mmday.MMD.activities.arc.ImagesView;
import com.mmday.MMD.interactors.ImagesInteractor;
import com.mmday.MMD.interactors.ImagesInteractorImpl;

public class ImagesPresenterImpl implements ImagesPresenter, OnFinishedListener {
    private final String categoryId;
    private ImagesView view;
    private ImagesInteractor interactor;

    public ImagesPresenterImpl(ImagesView view, String categoryId) {
        this.view = view;
        this.interactor = new ImagesInteractorImpl(this);
        this.categoryId = categoryId;
    }

    @Override
    public void load() {
        this.interactor.load(categoryId);
    }

    @Override
    public void onError() {
        //show error
    }

    @Override
    public void onSuccess() {
        this.view.updateImages(this.interactor.getImages());
    }
}
