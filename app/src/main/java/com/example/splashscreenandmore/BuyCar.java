package com.example.splashscreenandmore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class BuyCar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyCarData[] myMovieData = new MyCarData[]{
                new MyCarData("Avengers","2019 film",R.drawable.avenger),
                new MyCarData("Venom","2018 film",R.drawable.venom),
                new MyCarData("Batman Begins","2005 film",R.drawable.batman),
                new MyCarData("Jumanji","2019 film",R.drawable.jumanji),
                new MyCarData("Good Deeds","2012 film",R.drawable.good_deeds),
                new MyCarData("Hulk","2003 film",R.drawable.hulk),
                new MyCarData("Avatar","2009 film",R.drawable.avatar),
        };

        MyMovieAdapter myMovieAdapter = new MyMovieAdapter(myMovieData,BuyCar.this);
        recyclerView.setAdapter(myMovieAdapter);

    }
}
