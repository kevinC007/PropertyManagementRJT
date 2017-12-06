package com.example.shuangzhecheng.propertymanagementrjt.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by shuangzhecheng on 12/5/17.
 */

public class GoogleClient {
    public static final String TEST_URL = "http://maps.googleapis.com";
    private static Retrofit myInstance = null;

    public static Retrofit getRetrofit() {
        if (myInstance == null) {
            myInstance = new Retrofit
                    .Builder().baseUrl(TEST_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return myInstance;
    }
}
