package com.mmday.MMD.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ImageView;
import com.mmday.MMD.R;
import com.mmday.MMD.models.GeneralEnums;
import com.mmday.MMD.presenters.FullScreenImagePresenter;
import com.mmday.MMD.presenters.FullScreenImagePresenterImpl;

/**
 * Created by albert on 20.07.2014.
 */
public class FullscreenImageActivity extends Activity implements FullScreenImageView {
    private ImageView imageView;
    private FullScreenImagePresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_image_view);

        this.presenter = new FullScreenImagePresenterImpl(this);
        Intent intent = getIntent();
        String imageId = intent.getStringExtra(GeneralEnums.PARAM_IMAGE_ID.getValue());
        this.presenter.load(imageId);
    }

    @Override
    public void loadImage(ContactsContract.CommonDataKinds.Photo photo) {
        this.imageView = (ImageView) findViewById(R.id.imageView_fullScreen);
    }
}
