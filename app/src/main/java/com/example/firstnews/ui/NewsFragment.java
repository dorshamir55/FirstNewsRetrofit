package com.example.firstnews.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.firstnews.model.Consumer;
import com.example.firstnews.retrofit.APIClient;
import com.example.firstnews.retrofit.APIInterface;
import com.example.firstnews.model.Articles;
import com.example.firstnews.model.MainPOJO;
import com.example.firstnews.model.News;
import com.example.firstnews.adapter.NewsAdapter;
import com.example.firstnews.R;
import com.example.firstnews.viewmodel.IMainViewModel;
import com.example.firstnews.viewmodel.MainViewModel;

import java.util.List;

import static com.example.firstnews.ui.WeatherFragment.context;

public class NewsFragment extends Fragment {
    private IMainViewModel viewModel;
    NewsAdapter newsAdapter;
    RecyclerView recyclerView;
    //List<News> m_newsList;

    final String BASE_LINK = "https://newsapi.org/v2/top-headlines?country=il&category=sports&apiKey=77d0acf9be214ed4b7c4c438e081d389";
    final String DEFAULT_IMAGE ="https://aok.pte.hu/docs/felvi/image/sport-1.png";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.d("tag", "called onCreateView - News");
        return inflater.inflate(R.layout.news_fragment, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(getActivity()).get(MainViewModel.class);

        recyclerView = view.findViewById(R.id.news_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));



        Consumer<List<Articles>> consumerList = new Consumer<List<Articles>>() {
            @Override
            public void apply(List<Articles> param) {
                newsAdapter = new NewsAdapter(context, param);
                //newsAdapter.setData(param);
                recyclerView.setAdapter(newsAdapter);
                newsAdapter.notifyDataSetChanged();
            }
        };
        viewModel.getArticlesLiveData(consumerList, "il", "sports", "77d0acf9be214ed4b7c4c438e081d389");

    }

}
