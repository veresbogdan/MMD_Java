package com.mmday.MMD.services;

import android.provider.ContactsContract;
import com.mmday.MMD.presenters.OnFinishedListener;

public interface ThumbnailImageService {

    public void load(String imageId, OnFinishedListener listener);

    public ContactsContract.CommonDataKinds.Photo getThumbnail();
}
