package com.example.splashscreenandmore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyMovieAdapter extends RecyclerView.Adapter<MyMovieAdapter.ViewHolder> {

    MyCarData[] myMovieData;
    Context context;

    public MyMovieAdapter(MyCarData[] myMovieData, BuyCar activity) {
        this.myMovieData = myMovieData;
        this.context = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.car_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final MyCarData myMovieDataList = myMovieData[position];
        holder.textViewName.setText(myMovieDataList.getMovieName());
        holder.textViewList.setText(myMovieDataList.getListingPrice());
        holder.textViewDate.setText(myMovieDataList.getMovieDate());
        holder.movieImage.setImageResource(myMovieDataList.getMovieImage());

        //Display the name at the bottom as a confirmation
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, myMovieDataList.getMovieName(), Toast.LENGTH_SHORT).show();


            }
        });
    }

    @Override
    public int getItemCount() {
        return myMovieData.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView movieImage;
        TextView textViewName;
        TextView textViewList;
        TextView textViewDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            movieImage = itemView.findViewById(R.id.imageview);
            textViewName = itemView.findViewById(R.id.textName);
            textViewList = itemView.findViewById(R.id.text);
            textViewDate = itemView.findViewById(R.id.textdate);

        }
    }

}
