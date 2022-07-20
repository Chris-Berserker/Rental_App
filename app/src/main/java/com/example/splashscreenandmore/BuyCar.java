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
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import android.widget.Toast;

import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import java.util.Locale;

public class BuyCar extends AppCompatActivity {

    public Button button4;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_car);

        //Hides the status bar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //recyclerView here
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

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
}