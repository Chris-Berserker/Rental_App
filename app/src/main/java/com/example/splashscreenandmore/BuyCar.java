package com.example.splashscreenandmore;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.Toast;

import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import java.util.Locale;

public class BuyCar extends AppCompatActivity {

    public Button button4;
    RecyclerView recyclerView;
    BuyCarAdapter buyCarAdapter;
    Query query = FirebaseDatabase.getInstance().getReference().child("Vehicles");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_car);

        //Hides the status bar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getActionBar();


        //recyclerView here
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //firebase database
        FirebaseRecyclerOptions<BuyCarGetter> options =
                new FirebaseRecyclerOptions.Builder<BuyCarGetter>()
                        .setQuery(query, BuyCarGetter.class)
                        .build();

        buyCarAdapter = new BuyCarAdapter(options);
        recyclerView.setAdapter(buyCarAdapter);




        //toolbar Hamburger menu... goes to dashboard
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BuyCar.this, Dashboard.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        buyCarAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        buyCarAdapter.stopListening();
    }


    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                txtSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                txtSearch(query);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    private void txtSearch(String str){
        try{
        FirebaseRecyclerOptions<BuyCarGetter> options =
                new FirebaseRecyclerOptions.Builder<BuyCarGetter>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Vehicles").orderByChild("make").startAt(str).endAt(str+"~"), BuyCarGetter.class)
                        .build();

        buyCarAdapter = new BuyCarAdapter(options);
        buyCarAdapter.startListening();
        recyclerView.setAdapter(buyCarAdapter);}catch (Exception e) {
            e.printStackTrace();
        }
    }

}