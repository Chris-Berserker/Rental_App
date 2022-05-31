package com.example.splashscreenandmore;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class LoginPage extends AppCompatActivity {
    public Button loginbutton;
    public Button signupbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);


        loginbutton = (Button) findViewById(R.id.loginButton);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(LoginPage.this,Loading.class);
                startActivity(intent);
            }
        });

        signupbutton = (Button) findViewById(R.id.SignUpbutton);
        signupbutton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(LoginPage.this,SignupPage.class);
                startActivity(intent);
                Animatoo.animateSlideDown(LoginPage.this);
            }
        }));

    }
}