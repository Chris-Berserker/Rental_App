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
                new MyCarData("Tesla","Electric", R.drawable.avenger),
                new MyCarData("Nissan Qashqai","1500cc",R.drawable.venom),
                new MyCarData("Ford Ranger","1800cc",R.drawable.jumanji),
                new MyCarData("Suzuki","1000cc",R.drawable.good_deeds),
                new MyCarData("Ford Focus","1600cc",R.drawable.hulk),
                new MyCarData("Nissan 350z","2500cc",R.drawable.avatar),
        };

        MyMovieAdapter myMovieAdapter = new MyMovieAdapter(myMovieData,BuyCar.this);
        recyclerView.setAdapter(myMovieAdapter);


    }
}
