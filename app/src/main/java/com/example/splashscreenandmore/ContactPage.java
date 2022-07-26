package com.example.splashscreenandmore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;


public class ContactPage extends AppCompatActivity {

    Button contactbutton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_mechanic);

        //Hides the status bar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        contactbutton = (Button) findViewById(R.id.contactbutton);
        contactbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactPage.this, Dashboard.class);
                startActivity(intent);
            }
        });

    }
}
