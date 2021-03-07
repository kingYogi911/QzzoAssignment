package com.yogi.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.yogi.MovieDetailActiviry;
import com.yogi.R;
import com.yogi.models.MovieModel;
import com.yogi.utils.Constants;
import java.util.ArrayList;


public class MoviesListAdapter extends RecyclerView.Adapter<MoviesListAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<MovieModel> moviesList;

    public MoviesListAdapter(Context context,ArrayList<MovieModel> moviesList){
        this.context=context;
        this.moviesList=moviesList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.moives_item_rv,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MovieModel movie=moviesList.get(position);
        holder.tvMovieName.setText(movie.getOriginal_title());
        Picasso.get().load(Constants.IMAGE_BASE_URL+movie.getPoster_path())
                .resize(300,400)
                .into(holder.IvMovieImage);
        holder.IvMovieImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context, MovieDetailActiviry.class);
                i.putExtra("movie", movie);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView IvMovieImage;
        public TextView tvMovieName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            IvMovieImage=itemView.findViewById(R.id.movies_item_rv_poster);
            tvMovieName=itemView.findViewById(R.id.movies_item_rv_name);
        }
    }
}
