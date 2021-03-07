package com.yogi.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.yogi.R;
import com.yogi.models.TrailerModel;

import java.util.ArrayList;

import static com.yogi.utils.Constants.IMAGE_BASE_URL;

public class TrailerAdapter extends RecyclerView.Adapter<TrailerAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<TrailerModel> trailerList;
    public TrailerAdapter(Context context,ArrayList<TrailerModel> trailerList){
        this.context=context;
        this.trailerList=trailerList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.trailer_item_rv,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvTrailerSrNum.setText(String.valueOf(position+1));
        Picasso.get().load(IMAGE_BASE_URL+ trailerList.get(position).getThumbNailPath())
                .placeholder(R.drawable.ic_launcher_background)
                .resize(600,200)
                .into(holder.ivThumbnailImage);
    }

    @Override
    public int getItemCount() {
        return trailerList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivThumbnailImage;
        public TextView tvTrailerSrNum;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivThumbnailImage=itemView.findViewById(R.id.trailer_thumbnail_image);
            tvTrailerSrNum=itemView.findViewById(R.id.trailer_item_tarailer_count);
        }

    }
}
