package com.mmday.MMD.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import com.mmday.MMD.R;
import com.mmday.MMD.models.CategoryEntity;
import com.mmday.MMD.presenters.LoginPresenter;
import com.mmday.MMD.presenters.LoginPresenterImpl;
import com.mmday.MMD.services.CategoriesService;
import com.mmday.MMD.services.CategoriesServiceImpl;
import com.mmday.MMD.services.ImagesService;
import com.mmday.MMD.services.ImagesServiceImpl;

public class LoginActivity extends Activity implements LoginView, View.OnClickListener {

    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar = (ProgressBar) findViewById(R.id.progress);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        findViewById(R.id.button).setOnClickListener(this);

//        CategoriesService service = new CategoriesServiceImpl();
//        service.getCategories("");

        ImagesService imagesService = new ImagesServiceImpl();
        imagesService.getImagesFrom(new CategoryEntity("2"));

        presenter = new LoginPresenterImpl(this);
    }

    @Override public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override public void setUsernameError() {
        username.setError(getString(R.string.username_error));
    }

    @Override public void setPasswordError() {
        password.setError(getString(R.string.password_error));
    }

    @Override public void navigateToHome() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override public void onClick(View v) {
        presenter.loginWithCredentials(username.getText().toString(), password.getText().toString());
    }
}
