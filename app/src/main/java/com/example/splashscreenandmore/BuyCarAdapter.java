package com.example.splashscreenandmore;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class BuyCarAdapter extends FirebaseRecyclerAdapter<BuyCarGetter, BuyCarAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public BuyCarAdapter(@NonNull FirebaseRecyclerOptions<BuyCarGetter> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull BuyCarGetter model) {

        try{
        Glide.with(holder.img.getContext())
                .load(model.getImg())
                .placeholder(R.drawable.carload)
                .centerCrop()
                .error(R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.img);}catch (Exception e) {
            e.printStackTrace();
        }
        holder.make.setText(model.getMake());
        holder.millage.setText(model.getMillage());
        holder.model.setText(model.getModel());
        holder.price.setText(model.getPrice());
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_item_list,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        CircleImageView img;
        TextView price, make, model, millage;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            img = (CircleImageView) itemView.findViewById(R.id.imageview);
            make = (TextView) itemView.findViewById(R.id.maketx);
            millage = (TextView) itemView.findViewById(R.id.millagetx);
            model = (TextView) itemView.findViewById(R.id.modeltx);
            price = (TextView) itemView.findViewById(R.id.pricetx);
        }
    }
}
