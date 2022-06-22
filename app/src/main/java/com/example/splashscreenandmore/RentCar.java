package com.example.splashscreenandmore;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;

import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;


import org.jetbrains.annotations.Nullable;


public class RentCar extends AppCompatActivity {
    public Button button4;
    public EditText editComment;
    public Button btnSpeak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_car);
        //Hides the status bar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(view -> {
            Intent intent = new Intent(RentCar.this, Dashboard.class);
            startActivity(intent);
        });
        editComment = findViewById(R.id.editComment);
        btnSpeak = findViewById(R.id.micImg);

        btnSpeak.setOnClickListener(this::getSpeechInput);
    }

    public void getSpeechInput(View view) {

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Start Speaking...");
        startActivityForResult(intent, 111);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 111 && resultCode == RESULT_OK) {
            assert data != null;
            editComment.setText(data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS).get(0));
        }
    }

}

