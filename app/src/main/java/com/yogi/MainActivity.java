package com.yogi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.yogi.adapters.MoviesListAdapter;
import com.yogi.models.MovieModel;
import com.yogi.models.MoviesResponseModel;
import com.yogi.services.DatabaseService;
import com.yogi.services.RetrofitInstance;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvMovieList;
    private MoviesListAdapter adapter;
    private ArrayList<MovieModel> movieList=new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setRecyclerView();

        DatabaseService restDatabase=RetrofitInstance.getRetrofitInstance().create(DatabaseService.class);
        Call<MoviesResponseModel> asyncCall= restDatabase.getAllMovies();
        asyncCall.enqueue(new Callback<MoviesResponseModel>() {
            @Override
            public void onResponse(Call<MoviesResponseModel> call, Response<MoviesResponseModel> response) {
                if(response.isSuccessful()){
                    MoviesResponseModel res=response.body();
                    if(res!=null)
                        setMoviesData(res.getMoviesList());
                }
            }

            @Override
            public void onFailure(Call<MoviesResponseModel> call, Throwable t) {

            }
        });
    }
    public void initViews(){
        rvMovieList =findViewById(R.id.movies_main_rv);
    }
    public void setRecyclerView(){
        rvMovieList.setLayoutManager(new GridLayoutManager(this,2));
        adapter=new MoviesListAdapter(this,movieList);
        rvMovieList.setAdapter(adapter);

    }
    public void setMoviesData(ArrayList<MovieModel> moviesData){
        movieList.clear();
        movieList.addAll(moviesData);
        adapter.notifyDataSetChanged();
    }
}