package com.mmday.MMD.rest;

import android.app.Application;
import retrofit.RestAdapter;

public class RetrofitController extends Application {
    private static RetrofitController retrofitController;

    private RestAdapter restAdapter;
    private RequestInterceptor requestInterceptor;
    private static final String API_URL = "http://cloud.mm-day.com";

    private String authToken = null;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofitController = this;

        requestInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(final RequestFacade requestFacade) {
                if (authToken != null) {
                    requestFacade.addHeader("AUTH_TOKEN", authToken);
                }
            }
        };
    }

    public static synchronized RetrofitController getInstance() {
        return retrofitController;
    }

    public RestAdapter getRestAdapter() {
        if (restAdapter == null) {
            restAdapter = new RestAdapter.Builder().setRequestInterceptor(requestInterceptor).setLogLevel(RestAdapter.LogLevel.FULL).setEndpoint(API_URL).build();
        }

        return restAdapter;
    }

    public static synchronized <T> T create(java.lang.Class<T> service) {
        return getInstance().getRestAdapter().create(service);
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
