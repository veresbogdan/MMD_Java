package com.mmday.MMD.rest;

import android.app.Application;
import com.mmday.MMD.models.GeneralEnums;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

public class RetrofitController extends Application {
    private static RetrofitController retrofitController;

    private RestAdapter restAdapter;
    private RequestInterceptor requestInterceptor;

    private String authToken = null;

    public static synchronized RetrofitController getInstance() {
        return retrofitController;
    }

    public static synchronized <T> T create(java.lang.Class<T> service) {
        return getInstance().getRestAdapter().create(service);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        retrofitController = this;

        requestInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(final RequestFacade requestFacade) {
                if (authToken != null) {
                    requestFacade.addHeader("TOKEN", authToken);
                }
            }
        };
    }

    public RestAdapter getRestAdapter() {
        if (restAdapter == null) {
            restAdapter = new RestAdapter.Builder().setRequestInterceptor(requestInterceptor).setLogLevel(RestAdapter.LogLevel.FULL).setEndpoint(GeneralEnums.API_URL_ENDPOINT.getValue()).build();
        }

        return restAdapter;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
