package com.mmday.MMD.services;

import com.mmday.MMD.models.CategoryEntity;
import com.mmday.MMD.models.ImageEntity;
import com.mmday.MMD.rest.ImageDetailsListController;
import com.mmday.MMD.rest.RetrofitController;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ImagesServiceImpl implements ImagesService {
    Collection<ImageEntity> m_images;

    public ImagesServiceImpl() {
        m_images = new ArrayList<ImageEntity>();
    }

    @Override
    public Collection<ImageEntity> getImagesFrom(CategoryEntity categoryEntity) {
        ImageDetailsListController imagesController = RetrofitController.create(ImageDetailsListController.class);

        imagesController.getImages(categoryEntity, new Callback<List<ImageEntity>>() {
            @Override
            public void success(List<ImageEntity> images, Response response) {
                System.out.println("Images service response: " + response.getStatus());
                System.out.println("images: " + images);
                //TODO: find a better way to return this value
                m_images.addAll(images);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                System.out.println("ImagesService says: fuck this shit");
            }
        });
        return m_images;
    }
}
