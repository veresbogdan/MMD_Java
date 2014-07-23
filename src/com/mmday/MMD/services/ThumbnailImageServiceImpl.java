package com.mmday.MMD.services;

import android.provider.ContactsContract;
import com.mmday.MMD.presenters.OnFinishedListener;
import com.mmday.MMD.rest.RetrofitController;
import com.mmday.MMD.rest.ThumbnailImageController;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by albert on 20.07.2014.
 */
public class ThumbnailImageServiceImpl implements ThumbnailImageService {
    private final ThumbnailImageController thumbsController;
    private final List<ContactsContract.CommonDataKinds.Photo> photoList = new ArrayList<ContactsContract.CommonDataKinds.Photo>();

    public ThumbnailImageServiceImpl() {
        this.thumbsController = RetrofitController.create(ThumbnailImageController.class);
    }

    @Override
    public void load(String imageId, final OnFinishedListener listener) {
        this.photoList.clear();
        this.thumbsController.getImage(imageId, new Callback<ContactsContract.CommonDataKinds.Photo>() {
            @Override
            public void success(ContactsContract.CommonDataKinds.Photo receivedPhoto, Response response) {
                photoList.add(receivedPhoto);
                listener.onSuccess();
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                listener.onError();
            }
        });
    }

    @Override
    public ContactsContract.CommonDataKinds.Photo getThumbnail() {
        return this.photoList.get(0);
    }
}
