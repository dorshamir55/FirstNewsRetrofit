package com.example.firstnews;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

interface APIInterface {

    @GET("top-headlines?")
    Call<MainPOJO> getAllNews(@Query("country") String country,@Query("category") String category,@Query("apiKey") String apiKey);
}