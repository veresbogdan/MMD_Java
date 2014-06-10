package com.mmday.MMD.presenters;

import com.mmday.MMD.activities.arc.CategoriesView;
import com.mmday.MMD.interactors.CategoriesInteractor;
import com.mmday.MMD.interactors.CategoriesInteractorImpl;

public class CategoriesPresenterImpl implements CategoriesPresenter{
    private CategoriesView view;
    private CategoriesInteractor interactor;

    public CategoriesPresenterImpl(CategoriesView view)
    {
        this.view = view;
        this.interactor = new CategoriesInteractorImpl();
    }

}
