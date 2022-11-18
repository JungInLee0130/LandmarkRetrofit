package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface LandmarkAPI {
    @GET("/landmark/{id}")
    Call<Landmark> getLandmarkInfo(@Path("id") String id);

    @GET("/landmark/all")
    Call<List<Landmark>> getLandmarkList();

    @POST("/landmark/{id}")
    Call postLandmark(@Path("id") String id, String name, String pictures);

    @PUT("/landmark/{id}")
    Call putLandmark(@Path("id") String id, String name, String picture);

    @DELETE("/landmark/{id}")
    Call deleteLandmark(@Path("id") String id);
}
