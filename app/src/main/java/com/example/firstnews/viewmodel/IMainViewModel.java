package com.example.firstnews.viewmodel;

import androidx.lifecycle.LiveData;

import com.example.firstnews.model.Articles;
import com.example.firstnews.model.Consumer;

import java.util.List;

public interface IMainViewModel {
    public void getArticlesLiveData(Consumer<List<Articles>> consumer, String country, String category, String apiKey);
}
