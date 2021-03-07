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
import com.yogi.models.ReviewModel;
import com.yogi.models.TrailerModel;

import java.util.ArrayList;

import static com.yogi.utils.Constants.IMAGE_BASE_URL;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<ReviewModel> reviewList;
    public ReviewAdapter(Context context, ArrayList<ReviewModel> reviewList){
        this.context=context;
        this.reviewList=reviewList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.review_item_rv,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvSrNum.setText(String.valueOf(position+1));
        holder.tvComment.setText(reviewList.get(position).getComment());
    }

    @Override
    public int getItemCount() {
        return reviewList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvSrNum;
        public TextView tvComment;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSrNum=itemView.findViewById(R.id.review_sr_num);
            tvComment=itemView.findViewById(R.id.review_comment);
        }

    }
}
