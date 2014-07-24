package com.mmday.MMD.presenters;

import com.mmday.MMD.activities.MainView;
import com.mmday.MMD.interactors.CategoriesInteractor;
import com.mmday.MMD.interactors.CategoriesInteractorImpl;

public class CategoriesPresenterImpl implements CategoriesPresenter, OnFinishedListener {
    private final MainView view;
    private final CategoriesInteractor interactor;

    public CategoriesPresenterImpl(MainView mainView) {
        view = mainView;
        interactor = new CategoriesInteractorImpl(this);
    }

    @Override
    public void load() {
        view.showProgress();
        interactor.load();
    }

    @Override
    public void onError() {
        //TODO : show error in the view
        view.hideProgress();
    }

    @Override
    public void onSuccess() {
        view.setCategories(interactor.getCategories());
        view.hideProgress();
    }
}
