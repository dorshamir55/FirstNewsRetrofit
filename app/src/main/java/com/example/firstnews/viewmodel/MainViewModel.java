package com.example.firstnews.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.firstnews.model.Articles;
import com.example.firstnews.model.Consumer;
import com.example.firstnews.repository.IMainRepository;
import com.example.firstnews.repository.MainRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel implements IMainViewModel {
    private IMainRepository mainRepository;
    private LiveData<List<Articles>> articlesLiveDate;

    public MainViewModel(@NonNull Application application) {
        super(application);
        mainRepository = new MainRepository(application);
    }

    @Override
    public void getArticlesLiveData(Consumer<List<Articles>> consumer, String country, String category, String apiKey) {
        mainRepository.getArticlesLiveData(consumer, country, category, apiKey);
    }
}
