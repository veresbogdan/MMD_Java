package com.mmday.MMD.activities;

import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.mmday.MMD.R;
import com.mmday.MMD.activities.arc.ArcMenu;
import com.mmday.MMD.models.CategoryDto;
import com.mmday.MMD.models.GeneralEnums;
import com.mmday.MMD.presenters.CategoriesPresenter;
import com.mmday.MMD.presenters.CategoriesPresenterImpl;
import com.mmday.MMD.rest.RetrofitController;

import java.util.List;

public class MainActivity extends Activity implements MainView, CategoryClickHandler {
    private static AccountManager accountManager;
    private ArcMenu arcMenu;
    private CategoriesPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        accountManager = AccountManager.get(this);

        setAuthToken();

        setContentView(R.layout.main);
        arcMenu = (ArcMenu) findViewById(R.id.arc_menu);

        presenter = new CategoriesPresenterImpl(this);
        presenter.load();
    }

    private void setAuthToken() {
        accountManager.getAuthTokenByFeatures(GeneralEnums.ACCOUNT_TYPE.getValue(), GeneralEnums.AUTHTOKEN_TYPE_FULL_ACCESS.getValue(), null, this, null, null,
                new AccountManagerCallback<Bundle>() {
                    @Override
                    public void run(AccountManagerFuture<Bundle> future) {
                        Bundle bundle;
                        try {
                            bundle = future.getResult();
                            RetrofitController.getInstance().setAuthToken(bundle.getString(AccountManager.KEY_AUTHTOKEN));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                , null);
    }

    @Override
    public void showProgress() {
        arcMenu.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        arcMenu.setVisibility(View.VISIBLE);
    }

    @Override
    public void setCategories(List<CategoryDto> categories) {
        //TODO : call the addArcMenuItem method with random values
        int r = 0;
        for (CategoryDto category : categories) {
            addArcMenuItem(category,
                    r++ % 3 == 0 ? R.drawable.mm_20 : r++ % 2 == 0 ? R.drawable.mm_36 : R.drawable.mm_30,
                    r++ % 3 == 1 ? 1.2f : r % 2 == 0 ? 1.0f : 0.9f);
        }
    }

    private void addArcMenuItem(CategoryDto categoryDto, int resource, float scale) {
        //TODO : instead of a simple ImageView, here we need a composite object that has
        //an image and a textView in order to show the category name / notifications maybe
        ImageView item = new ImageView(this);
        item.setImageResource(resource);

        item.setScaleType(ImageView.ScaleType.FIT_CENTER);
        item.setScaleX(scale);
        item.setScaleY(scale);

        arcMenu.addItem(item, new CategoryClickListener(categoryDto, this));
    }

    @Override

    public void onClick(CategoryDto categoryDto) {
        goToCategory(categoryDto.getId().toString());
    }

    private void goToCategory(String categoryId) {
        Intent intent = new Intent(getApplicationContext(), ImagesActivity.class);
        intent.putExtra(GeneralEnums.PARAM_CATEGORY_ID.getValue(), categoryId);

        startActivity(intent);
    }
}
