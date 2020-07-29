package com.example.firstnews.repository;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.firstnews.model.Articles;
import com.example.firstnews.model.MainPOJO;
import com.example.firstnews.retrofit.APIClient;
import com.example.firstnews.retrofit.APIInterface;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainRepository implements IMainRepository {
    MutableLiveData<List<Articles>> articles = new MutableLiveData<>();
    private Context context;

    public MainRepository(Application application) {
        this.context = application.getApplicationContext();
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public void getArticlesLiveData(String country, String category, String apiKey) {
        Handler handler = new Handler();

        APIInterface apiInterface = APIClient.getRetrofitInstance().create(APIInterface.class);
        Call<MainPOJO> call = apiInterface.getAllNews("il", "sports", "77d0acf9be214ed4b7c4c438e081d389");

        call.enqueue(new Callback<MainPOJO>() {

            @Override
            public void onResponse(Call<MainPOJO> call, retrofit2.Response<MainPOJO> response) {

                articles.setValue(Arrays.asList(response.body().getArticles()));
            }

            @Override
            public void onFailure(Call<MainPOJO> call, Throwable t) {
                articles.setValue(null);
                Toast.makeText(context, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void doAsynch(Runnable task) {
        new Thread(task).start();
    }

    public LiveData<List<Articles>> getArticles(){
        return  articles;
    }
}
