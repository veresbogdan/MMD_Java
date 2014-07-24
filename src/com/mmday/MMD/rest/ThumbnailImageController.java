package com.mmday.MMD.rest;

import android.provider.ContactsContract;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

public interface ThumbnailImageController {
    @GET("/image/full/{id}")
    void getImage(@Path("id") String id, Callback<ContactsContract.CommonDataKinds.Photo> photoCallback);
}
