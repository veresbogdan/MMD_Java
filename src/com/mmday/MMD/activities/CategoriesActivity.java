package com.mmday.MMD.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.mmday.MMD.R;
import com.mmday.MMD.activities.arc.CategoriesView;
import com.mmday.MMD.presenters.CategoriesPresenter;
import com.mmday.MMD.presenters.CategoriesPresenterImpl;

public class CategoriesActivity extends Activity implements CategoriesView{
    private ProgressBar progressBar;
    private ListView listView;
    private CategoriesPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        this.progressBar = (ProgressBar)findViewById(R.id.categ_progressBar);
        this.listView = (ListView)findViewById(R.id.categ_listView);

        this.presenter = new CategoriesPresenterImpl(this);
    }
}