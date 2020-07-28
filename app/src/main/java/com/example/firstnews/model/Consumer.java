package com.example.firstnews.model;

import androidx.recyclerview.widget.RecyclerView;

import com.example.firstnews.adapter.NewsAdapter;

public interface Consumer<T> {
    public void apply(T param, NewsAdapter adapter);
}
