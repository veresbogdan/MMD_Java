package com.mmday.MMD.rest;

import android.app.Application;
import retrofit.RestAdapter;

public class RetrofitController extends Application {
    private static RetrofitController retrofitController;

    private RestAdapter restAdapter;
    private static final String API_URL = "http://cloud.mm-day.com";

    @Override
    public void onCreate() {
        super.onCreate();

        retrofitController = this;
    }

    public static synchronized RetrofitController getInstance() {
        return retrofitController;
    }

    public RestAdapter getRestAdapter() {
        if (restAdapter == null) {
            restAdapter = new RestAdapter.Builder().setLogLevel(RestAdapter.LogLevel.FULL).setEndpoint(API_URL).build();
        }

        return restAdapter;
    }
}
