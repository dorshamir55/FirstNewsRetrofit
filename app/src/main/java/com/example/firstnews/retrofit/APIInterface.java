package com.example.firstnews.retrofit;

import com.example.firstnews.model.MainPOJO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("top-headlines")
    Call<MainPOJO> getAllNews(@Query("country") String country, @Query("category") String category, @Query("apiKey") String apiKey);
//    https://newsapi.org/v2/top-headlines?country=il&category=sports&apiKey=77d0acf9be214ed4b7c4c438e081d389
}