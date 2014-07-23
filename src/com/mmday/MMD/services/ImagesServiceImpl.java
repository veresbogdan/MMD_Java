package com.mmday.MMD.services;

import com.mmday.MMD.models.ImageDto;
import com.mmday.MMD.presenters.OnFinishedListener;
import com.mmday.MMD.rest.ImagesController;
import com.mmday.MMD.rest.RetrofitController;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import java.util.ArrayList;
import java.util.List;

public class ImagesServiceImpl implements ImagesService {
    private static ImagesController imagesController;
    private final List<ImageDto> images = new ArrayList<ImageDto>();

    public ImagesServiceImpl() {
        imagesController = RetrofitController.create(ImagesController.class);
    }

    @Override
    public void loadImages(String categoryId, final OnFinishedListener onFinishedListener) {
        //TODO maybe pass the listener as param on the constructor
        this.images.clear();

        imagesController.getImages(categoryId, new Callback<List<ImageDto>>() {
            @Override
            public void success(List<ImageDto> receivedImages, Response response) {
                System.out.println("Images service response: " + response.getStatus());

                images.addAll(receivedImages);
                onFinishedListener.onSuccess();
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                System.out.println("ImagesService says: fuck this shit");
                onFinishedListener.onError();
            }
        });
    }

    @Override
    public List<ImageDto> getImages() {
        return this.images;
    }
}
