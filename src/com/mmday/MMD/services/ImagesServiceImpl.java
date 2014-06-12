package com.mmday.MMD.services;

import com.mmday.MMD.models.CategoryDto;
import com.mmday.MMD.models.ImageDto;
import com.mmday.MMD.rest.ImageDetailsListController;
import com.mmday.MMD.rest.RetrofitController;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import java.util.ArrayList;
import java.util.List;

public class ImagesServiceImpl implements ImagesService {
    private static ImageDetailsListController imageDetailsListController;

    List<ImageDto> m_images;

    public ImagesServiceImpl() {
        imageDetailsListController = RetrofitController.create(ImageDetailsListController.class);
        m_images = new ArrayList<ImageDto>();
    }

    //TODO: find a better way to return this value
    @Override
    public void getImages(CategoryDto categoryDto) {
        imageDetailsListController.getImages(categoryDto, new Callback<List<ImageDto>>() {
            @Override
            public void success(List<ImageDto> images, Response response) {
                System.out.println("Images service response: " + response.getStatus());
                System.out.println("images: " + images);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                System.out.println("ImagesService says: fuck this shit");
            }
        });
    }
}
