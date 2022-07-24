package com.example.splashscreenandmore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.alan.alansdk.AlanCallback;
import com.alan.alansdk.AlanConfig;
import com.alan.alansdk.button.AlanButton;
import com.alan.alansdk.events.EventCommand;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONException;
import org.json.JSONObject;


public class Dashboard extends AppCompatActivity {
    public Button buybutton;
    public Button rentbutton;
    public Button speechbutton;
    public Button btnLogOut;
    public Button sellCar;
    FirebaseAuth mauth;
    private AlanButton alanButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

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
                        case "navigateToRent":
                            Intent intent = new Intent(Dashboard.this, RentCar.class);
                            startActivity(intent);
                            break;
                        case "navigateToBuy":
                            Intent intent1 = new Intent(Dashboard.this, BuyCar.class);
                            startActivity(intent1);
                            break;
                        case "navigateToSell":
                            Intent intent2 = new Intent(Dashboard.this, SellCar.class);
                            startActivity(intent2);
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

    void setVisualState() {
        JSONObject params = new JSONObject();
        try {
            params.put("screen","Dashboard");
        } catch (JSONException e) {
            Log.e("AlanButton", e.getMessage());
        }
        alanButton.setVisualState(params.toString());
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
