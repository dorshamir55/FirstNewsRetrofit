package com.example.firstnews.remote;

import com.example.firstnews.model.Articles;
import com.example.firstnews.model.Consumer;

import java.util.List;

public interface IMainRemoteDataSource {
    public void getAllArticles(Consumer<List<Articles>> consumer, String country, String category, String apiKey);
}
