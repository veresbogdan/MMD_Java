package com.mmday.MMD.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.mmday.MMD.R;
import com.mmday.MMD.activities.arc.ImagesView;
import com.mmday.MMD.models.GeneralEnums;
import com.mmday.MMD.models.ImageDto;
import com.mmday.MMD.presenters.ImagesPresenter;
import com.mmday.MMD.presenters.ImagesPresenterImpl;

import java.util.ArrayList;
import java.util.List;

public class ImagesActivity extends Activity implements ImagesView {
    private final List<ImageDto> images = new ArrayList<ImageDto>();
    private ProgressBar progressBar;
    private ImagesPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

//        this.progressBar = new ProgressBar(this);
//        this.progressBar.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
//                FrameLayout.LayoutParams.WRAP_CONTENT, Gravity.CENTER));
//        this.progressBar.setIndeterminate(true);
//        getListView().setEmptyView(this.progressBar);
        // Must add the progress bar to the root of the layout
//        ViewGroup root = (ViewGroup) findViewById(android.R.id.content);
//        root.addView(progressBar);

        Intent intent = getIntent();
        String categoryId = intent.getStringExtra(GeneralEnums.PARAM_CATEGORY_ID.getValue());
        presenter = new ImagesPresenterImpl(this, categoryId);
        presenter.load();
    }

    @Override
    public void updateImages(List<ImageDto> imagesList) {
        //TODO : check for performance issues. How could we reuse the images activity
        //if it already was created/started once?
        final ListView listview = (ListView) findViewById(R.id.listview);

        images.clear();
        images.addAll(imagesList);

        final CustomListAdapter adapter = new CustomListAdapter(this, imagesList);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageDto current = images.get(position);

                Intent intent = new Intent(getApplicationContext(), FullscreenImageActivity.class);
                intent.putExtra(GeneralEnums.PARAM_IMAGE_ID.getValue(), current.getCategoryId().toString());

                startActivity(intent);
            }
        });
    }
}