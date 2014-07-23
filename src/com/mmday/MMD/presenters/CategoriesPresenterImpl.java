package com.mmday.MMD.presenters;

import com.mmday.MMD.activities.MainView;
import com.mmday.MMD.interactors.CategoriesInteractor;
import com.mmday.MMD.interactors.CategoriesInteractorImpl;

/**
 * Created by albert on 20.07.2014.
 */
public class CategoriesPresenterImpl implements CategoriesPresenter, OnFinishedListener {
    private final MainView view;
    private final CategoriesInteractor interactor;

    public CategoriesPresenterImpl(MainView view) {
        this.view = view;
        this.interactor = new CategoriesInteractorImpl(this);
    }

    @Override
    public void load() {
        this.view.showProgress();
        this.interactor.load();
    }

    @Override
    public void onError() {
        //TODO : show error in the view
        this.view.hideProgress();
    }

    @Override
    public void onSuccess() {
        this.view.setCategories(this.interactor.getCategories());
        this.view.hideProgress();
    }
}
