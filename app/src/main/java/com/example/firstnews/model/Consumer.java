package com.example.firstnews.model;

public interface Consumer<T> {
    public void apply(T param);
}
