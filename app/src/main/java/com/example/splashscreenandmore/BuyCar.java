package com.example.splashscreenandmore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class BuyCar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_car);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyCarData[] myMovieData = new MyCarData[]{
                new MyCarData("Tesla","Rs 2,840,000","Electric", R.drawable.avenger),
                new MyCarData("Nissan Qashqai","Rs 1,480,000" ,"1500cc",R.drawable.venom),
                new MyCarData("Ford Ranger", "Rs 2,400,000","1800cc",R.drawable.jumanji),
                new MyCarData("Suzuki", "Rs 500,000","1000cc",R.drawable.good_deeds),
                new MyCarData("Ford Focus", "Rs 1,200,000","1600cc",R.drawable.hulk),
                new MyCarData("Nissan 350z","Rs 1,950,000" ,"2500cc",R.drawable.avatar),
        };

        MyMovieAdapter myMovieAdapter = new MyMovieAdapter(myMovieData,BuyCar.this);
        recyclerView.setAdapter(myMovieAdapter);


    }
}
