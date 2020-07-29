package com.example.firstnews.repository;

import androidx.lifecycle.LiveData;

import com.example.firstnews.model.Articles;
import com.example.firstnews.model.Consumer;

import java.util.List;

public interface IMainRepository {
    public void getArticlesLiveData(String country, String category, String apiKey);
    public LiveData<List<Articles>> getArticles();

}
