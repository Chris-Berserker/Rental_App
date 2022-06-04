package com.example.splashscreenandmore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity{
    public Button buybutton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        buybutton = (Button) findViewById(R.id.buybutton);
        buybutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Dashboard.this, BuyCar.class);
                startActivity(intent);
            }
        });

    }
}
