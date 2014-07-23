package com.mmday.MMD.services;

import android.provider.ContactsContract;
import com.mmday.MMD.presenters.OnFinishedListener;

/**
 * Created by albert on 20.07.2014.
 */
public interface ThumbnailImageService {
    void load(String imageId, OnFinishedListener listener);

    ContactsContract.CommonDataKinds.Photo getThumbnail();
}
