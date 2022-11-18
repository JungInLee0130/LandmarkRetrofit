package com.example.myapplication;

import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient instance = null;
    private static UserRetrofitInterface userRetrofitInterface;
    private static LandmarkAPI landmarkAPI;
    private static String baseUrl = "http://10.0.2.2:8080/";

    private RetrofitClient() {
        retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        userRetrofitInterface = retrofit.create(UserRetrofitInterface.class);
        landmarkAPI = retrofit.create(LandmarkAPI.class);
    }

    public static RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public static UserRetrofitInterface getUserRetrofitInterface() {
        return userRetrofitInterface;
    }
    public static LandmarkAPI getLandmarkAPI() {
        return landmarkAPI;
    }
}
