package com.example.firstnews.repository;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.provider.ContactsContract;

import androidx.lifecycle.LiveData;

import com.example.firstnews.adapter.NewsAdapter;
import com.example.firstnews.model.Articles;
import com.example.firstnews.model.Consumer;
import com.example.firstnews.model.MainPOJO;
import com.example.firstnews.remote.IMainRemoteDataSource;
import com.example.firstnews.remote.MainRemoteDataSource;
import com.example.firstnews.retrofit.APIClient;
import com.example.firstnews.retrofit.APIInterface;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainRepository implements IMainRepository {

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
    public void getArticlesLiveData(Consumer<List<Articles>> consumer, String country, String category, String apiKey) {
        Handler handler = new Handler();

        APIInterface apiInterface = APIClient.getRetrofitInstance().create(APIInterface.class);
        Call<MainPOJO> call = apiInterface.getAllNews("il", "sports", "77d0acf9be214ed4b7c4c438e081d389");
        //List<News> newsList = new ArrayList<>();

        call.enqueue(new Callback<MainPOJO>() {

            @Override
            public void onResponse(Call<MainPOJO> call, retrofit2.Response<MainPOJO> response) {
                doAsynch(()->{
                    List<Articles> articles = Arrays.asList(response.body().getArticles());
                    NewsAdapter adapter = new NewsAdapter(context, Arrays.asList(response.body().getArticles()));
/*                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(newsAdapter);*/
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            if(consumer!=null) {
                                consumer.apply(articles);//, adapter);
                            }
                        }
                    });
                });
            }

            @Override
            public void onFailure(Call<MainPOJO> call, Throwable t) {

                //Toast.makeText(context, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void doAsynch(Runnable task) {
        new Thread(task).start();
    }
}
