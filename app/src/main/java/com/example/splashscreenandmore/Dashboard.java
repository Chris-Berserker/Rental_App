package com.example.splashscreenandmore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Dashboard extends AppCompatActivity {
    public Button buybutton;
    public Button rentbutton;
    public Button contactb;
    public Button btnLogOut;
    public Button sellCar;
    FirebaseAuth mauth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        //Hides the status bar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        sellCar = (Button)findViewById(R    .id.sellcar);
        sellCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, SellCar.class);
                startActivity(intent);
            }
        });

        contactb = (Button) findViewById(R.id.contactbt);
        contactb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, ContactPage.class);
                startActivity(intent);
            }
        });

        buybutton = (Button) findViewById(R.id.buybutton);
        buybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, BuyCar.class);
                startActivity(intent);
            }
        });

        rentbutton = (Button) findViewById(R.id.rentbutton);
        rentbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, RentCar.class);
                startActivity(intent);
            }
        });


        btnLogOut = findViewById(R.id.logoutBtn);
        mauth = FirebaseAuth.getInstance();

        btnLogOut.setOnClickListener(view ->{
            mauth.signOut();
            startActivity(new Intent(Dashboard.this, LoginPage.class));
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mauth.getCurrentUser();
        if (user == null) {
            startActivity(new Intent(Dashboard.this, FirstPageActivity.class));
        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Toast.makeText(this, "Cannot go back", Toast.LENGTH_SHORT).show();
    }
}
