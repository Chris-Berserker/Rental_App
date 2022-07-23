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
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.alan.alansdk.AlanCallback;
import com.alan.alansdk.AlanConfig;
import com.alan.alansdk.button.AlanButton;
import android.widget.Toast;

import android.widget.ImageButton;
import android.widget.TextView;

import com.alan.alansdk.AlanConfig;
import com.alan.alansdk.button.AlanButton;
import com.alan.alansdk.events.EventCommand;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import java.util.Locale;


public class RentCar extends AppCompatActivity {

    List<MyCarData> myCarDataList;
    BottomNavigationView navigationView;
    public Button button4;
    public TextView speechTextDisplay;
    private AlanButton alanButton;
    private static final int RECOGNIZER_RESULT = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_car);
        //Hides the status bar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /// Set up the Alan button
        AlanConfig config = AlanConfig.builder().setProjectId("e1d15f29fb2cb2f3af195200e275302d2e956eca572e1d8b807a3e2338fdd0dc/stage").build();
        alanButton = findViewById(R.id.alan_button);
        alanButton.initWithConfig(config);
        //Commands for Alan
        setVisualState();

        AlanCallback alanCallback = new AlanCallback() {
            /// Handle commands from Alan Studio
            @Override
            public void onCommand(final EventCommand eventCommand) {
                try {
                    JSONObject command = eventCommand.getData();
                    String commandName = command.getJSONObject("data").getString("command");
                    switch(commandName) {
                        case "navigateToDash":
                            Intent intent = new Intent(RentCar.this, Dashboard.class);
                            startActivity(intent);
                            break;


                    }
                    //Log.d("AlanButton", "onCommand: commandName: " + commandName);
                } catch (JSONException e) {
                    Log.e("AlanButton", e.getMessage());
                }
            }
        };

        /// Register callbacks
        alanButton.registerCallback(alanCallback);

        //toolbar Hamburger menu... goes to dashboard

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RentCar.this, Dashboard.class);
                startActivity(intent);
            }
        });




        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        myCarDataList = new ArrayList<>();
        myCarDataList.add(new MyCarData("Tesla","Rs 7732/Day","Electric", R.drawable.avenger));
        myCarDataList.add(new MyCarData("Nissan Qashqai","Rs 4029/Day" ,"1500cc",R.drawable.venom));
        myCarDataList.add(new MyCarData("Ford Ranger", "Rs 6534/Day","1800cc",R.drawable.jumanji));
        myCarDataList.add(new MyCarData("Ford Focus", "Rs 3267/Day","1600cc",R.drawable.hulk));
        myCarDataList.add(new MyCarData("Suzuki", "Rs 1361/Day","1000cc",R.drawable.good_deeds));
        myCarDataList.add(new MyCarData("Nissan 350z","Rs 5300/Day" ,"2500cc",R.drawable.avatar));

        MyCarData[] myMovieData = new MyCarData[]{
                new MyCarData("Tesla","Rs 7732/Day","Electric", R.drawable.avenger),
                new MyCarData("Nissan Qashqai","Rs 4029/Day" ,"1500cc",R.drawable.venom),
                new MyCarData("Ford Ranger", "Rs 6534/Day","1800cc",R.drawable.jumanji),
                new MyCarData("Suzuki", "Rs 1361/Day","1000cc",R.drawable.good_deeds),
                new MyCarData("Ford Focus", "Rs 3267/Day","1600cc",R.drawable.hulk),
                new MyCarData("Nissan 350z","Rs 5300/Day" ,"2500cc",R.drawable.avatar),
        };

        MyMovieAdapter myMovieAdapter = new MyMovieAdapter(myCarDataList,RentCar.this);
        recyclerView.setAdapter(myMovieAdapter);
    }

    //command for Alan showing it it's the renting screen
    void setVisualState() {
        JSONObject params = new JSONObject();
        try {
            params.put("screen","rent");
        } catch (JSONException e) {
            Log.e("AlanButton", e.getMessage());
        }
        alanButton.setVisualState(params.toString());
    }


    @Override
    protected void onStart() {
        super.onStart();
    }
}


