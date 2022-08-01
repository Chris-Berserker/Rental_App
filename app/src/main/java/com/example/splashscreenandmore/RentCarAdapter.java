package com.example.splashscreenandmore;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RentCarAdapter extends RecyclerView.Adapter<RentCarAdapter.ViewHolder>{

    private ArrayList<MyCarData> myCarData = new ArrayList<>();

    private Context context;

    public RentCarAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_item_list_2,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.car_name.setText(myCarData.get(position).getCar_name());
        holder.car_rent_price.setText(myCarData.get(position).getCar_rent_price());
        holder.car_type.setText(myCarData.get(position).getCar_type());

        Glide.with(context)
                .asBitmap()
                .load(myCarData.get(position).getImg())
                .into(holder.img);

        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), Full_Details_2.class);

                v.getContext().startActivity(myIntent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return myCarData.size();
    }

    public void setMyCarData(ArrayList<MyCarData> myCarData) {
        this.myCarData = myCarData;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView car_name,car_rent_price,car_type;
        private ImageView img;
        public View v;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            car_name = itemView.findViewById(R.id.textName);
            car_rent_price = itemView.findViewById(R.id.text);
            car_type = itemView.findViewById(R.id.textdate);
            img = itemView.findViewById(R.id.imageview);
            v = itemView;
        }
    }

}
