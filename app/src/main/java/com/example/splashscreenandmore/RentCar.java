package com.example.splashscreenandmore;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alan.alansdk.AlanCallback;
import com.alan.alansdk.AlanConfig;
import com.alan.alansdk.button.AlanButton;
import com.alan.alansdk.events.EventCommand;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.api.*;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RentCar extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    List<MyCarData> myCarDataList;
    public Button button4;
    private AlanButton alanButton;
    private ArrayList<MyCarData> myCarData;
    private Map<String, Object> hashmap;
    private FirebaseFirestore db;
    private static final String TAG ="RentCar";
    private RentCarAdapter adapter;


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

        //Recycler View codes

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        myCarData = new ArrayList<>();
        hashmap = new HashMap<>();
        adapter = new RentCarAdapter(this);
        getAllCars();








        recyclerView.setAdapter(adapter);
        linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);



    }

    public void getAllCars() {
        // [START get_all_users]
        db = FirebaseFirestore.getInstance();
        db.collection("Vehicle")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                String car_name,car_rent_price,car_type,img;

                                car_name= document.getString("car_name");
                                car_rent_price= document.getString("car_rent_price");
                                car_type= document.getString("car_type");
                                img= document.getString("img");
                                myCarData.add(new MyCarData(car_name,car_rent_price,car_type,img));
                                adapter.setMyCarData(myCarData);

                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
        // [END get_all_users]
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

    @Override
    protected void onStop() {
        super.onStop();
    }

}


