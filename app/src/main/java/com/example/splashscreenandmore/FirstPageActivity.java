package com.example.splashscreenandmore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class FirstPageActivity extends AppCompatActivity {
    public Button button;
    public Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        final ImageView demoimage = findViewById(R.id.carrexlogo);
        demoimage.startAnimation(AnimationUtils.loadAnimation(
                getApplicationContext(),
                R.anim.zoom_in

        ));

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(FirstPageActivity.this,LoginPage.class);
                startActivity(intent);
                Animatoo.animateSlideLeft(FirstPageActivity.this);
            }
        });

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(FirstPageActivity.this,SignupPage.class);
                startActivity(intent);
                Animatoo.animateSlideRight(FirstPageActivity.this);
            }
        });

    }
}

