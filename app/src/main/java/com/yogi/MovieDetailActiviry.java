package com.yogi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.yogi.adapters.ReviewAdapter;
import com.yogi.adapters.TrailerAdapter;
import com.yogi.models.MovieModel;
import com.yogi.models.ReviewModel;
import com.yogi.models.TrailerModel;

import java.util.ArrayList;

public class MovieDetailActiviry extends AppCompatActivity {
    private RecyclerView rvTrailers;
    private RecyclerView rvReviews;
    private TextView tvLanguage,tvReleaseDate,tvPopularity,tvRating,tvVoteCount,tvDescription;
    private MovieModel movie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail_activiry);
        initViews();
        Intent i=getIntent();
        movie = (MovieModel) i.getSerializableExtra("movie");
        if(movie!=null){
            this.setTitle(movie.getOriginal_title());//Settting Activity Name
            setmovieDetailData();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_movie,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_movie:
                new AlertDialog.Builder(this)
                        .setCancelable(true)
                        .setMessage("This Feature is not implemented Yet")
                        .create()
                        .show();
                return true;
            default: return false;
        }
    }

    void setmovieDetailData(){
        setRecyclerViews();
        tvLanguage.setText(movie.getOriginal_language());
        tvReleaseDate.setText(movie.getRelease_date());
        tvPopularity.setText(String.valueOf(movie.getPopularity()));
        tvRating.setText(String.valueOf(movie.getVote_average()));
        tvVoteCount.setText(String.valueOf(movie.getVote_count()));
        tvDescription.setText(movie.getOverview());
    }
    void setRecyclerViews(){
        ArrayList<TrailerModel> trailerList =new ArrayList<>();
        trailerList.addAll(getTestTrailers());
        TrailerAdapter tAdapter =new TrailerAdapter(this,trailerList);
        rvTrailers.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rvTrailers.setAdapter(tAdapter);


        ArrayList<ReviewModel> reviewList=new ArrayList<>();
        reviewList.addAll(getTestReviews());
        ReviewAdapter rAdapter=new ReviewAdapter(this,reviewList);
        rvReviews.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rvReviews.setAdapter(rAdapter);
    }

    //can be changed to access Trailer data from server
    public ArrayList<TrailerModel> getTestTrailers(){
        ArrayList<TrailerModel> temp=new ArrayList<>();
        temp.add(new TrailerModel("",movie.getBackdrop_path()));
        temp.add(new TrailerModel("",movie.getBackdrop_path()));
        temp.add(new TrailerModel("",movie.getBackdrop_path()));
        return temp;
    }

    //can be changed to access Reviews data from server
    public ArrayList<ReviewModel> getTestReviews(){
        ArrayList<ReviewModel> temp=new ArrayList<>();
        temp.add(new ReviewModel("This is Test Review 1 and Later can be Fetched from server"));
        temp.add(new ReviewModel("This is Test Review 2 and Later can be Fetched from server"));
        temp.add(new ReviewModel("This is Test Review 3 and Later can be Fetched from server"));
        return temp;
    }

    void initViews(){
        rvTrailers=findViewById(R.id.movie_detail_trailers_rv);
        rvReviews=findViewById(R.id.movie_detail_reviews_rv);
        tvLanguage=findViewById(R.id.movie_detail_item_language);
        tvReleaseDate=findViewById(R.id.movie_detail_item_release_date);
        tvPopularity=findViewById(R.id.movie_detail_item_popularity);
        tvRating=findViewById(R.id.movie_detail_item_average_rating);
        tvVoteCount=findViewById(R.id.movie_detail_item_vote_count);
        tvDescription=findViewById(R.id.movie_detail_item_description);
    }
}