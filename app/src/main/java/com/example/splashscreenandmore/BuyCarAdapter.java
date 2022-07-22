package com.example.splashscreenandmore;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.core.Context;

import de.hdodenhof.circleimageview.CircleImageView;

public class BuyCarAdapter extends FirebaseRecyclerAdapter<BuyCarGetter, BuyCarAdapter.myViewHolder> {
    private Context context;


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public BuyCarAdapter(@NonNull FirebaseRecyclerOptions<BuyCarGetter> options) {
        super(options);
        this.context = context;
    }

    @Override

    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull BuyCarGetter model) {


        protected void onBindViewHolder (@NonNull myViewHolder holder,
        @SuppressLint("RecyclerView") int position, @NonNull BuyCarGetter model){

            try {
                Glide.with(holder.img.getContext())
                        .load(model.getImg())
                        .placeholder(R.drawable.carload)
                        .centerCrop()
                        .error(R.drawable.common_google_signin_btn_icon_dark_normal)
                        .into(holder.img);
            } catch (Exception e) {
                e.printStackTrace();
            }
            holder.make.setText(model.getMake());
            holder.millage.setText(model.getMillage());
            holder.model.setText(model.getModel());
            holder.price.setText(model.getPrice());

            holder.v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(v.getContext(), Full_Details.class);
                    myIntent.putExtra("VehiclesKey", getRef(position).getKey());
                    v.getContext().startActivity(myIntent);


                }
            });
        }

        @NonNull
        @Override
        public myViewHolder onCreateViewHolder (@NonNull ViewGroup parent,int viewType){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_item_list, parent, false);
            return new myViewHolder(view);

        }

        class myViewHolder extends RecyclerView.ViewHolder {


            CircleImageView img;

            TextView textView;
            public View v;
            ImageView img;
            TextView price, make, model, millage;


            public myViewHolder(@NonNull View itemView) {
                super(itemView);

                img = (CircleImageView) itemView.findViewById(R.id.imageview);
                make = (TextView) itemView.findViewById(R.id.maketx);
                millage = (TextView) itemView.findViewById(R.id.millagetx);
                model = (TextView) itemView.findViewById(R.id.modeltx);
                price = (TextView) itemView.findViewById(R.id.pricetx);
                textView = itemView.findViewById(R.id.carTitle);
                v = itemView;

            }
        }
    }
}
