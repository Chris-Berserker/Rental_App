package com.example.splashscreenandmore;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.alan.alansdk.AlanCallback;
import com.alan.alansdk.button.AlanButton;
import com.alan.alansdk.events.EventCommand;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SellCar extends AppCompatActivity {

    public EditText priceText, makeText, modelText, imgText, millageText;
    public Button doneButton;
    private AlanButton alanButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selling_page);

        //Hides the status bar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

    priceText = (EditText) findViewById(R.id.textInputLayout2);
    modelText = (EditText) findViewById(R.id.textInputLayout3);
    imgText = (EditText) findViewById(R.id.textInputLayout6);
    makeText = (EditText) findViewById(R.id.textInputLayout5);
    millageText = (EditText) findViewById(R.id.textInputLayout7);

    doneButton = (Button) findViewById(R.id.sellingdonebutton);


    //setting Alan
        alanButton = findViewById(R.id.alan_button);
    //Calling Alan
        setVisualState();
        alanButton.registerCallback(alanCallback);

    doneButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            insertData();
            clearAll();
        }
    });

    }

    private void insertData(){
        Map<String,Object> map = new HashMap<>();
        if(!priceText.getText().toString().equals("") || !modelText.getText().toString().equals("") || !makeText.getText().toString().equals("")){
        map.put("price", priceText.getText().toString());
        map.put("model", modelText.getText().toString());
        map.put("img", imgText.getText().toString());
        map.put("make", makeText.getText().toString());
        map.put("millage", millageText.getText().toString());
        }

        FirebaseDatabase.getInstance().getReference().child("Vehicles").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(SellCar.this, "Data Has Been Registered", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        Toast.makeText(SellCar.this, "Error Registering Data", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void clearAll(){
        priceText.setText("");
        modelText.setText("");
        imgText.setText("");
        makeText.setText("");
        millageText.setText("");
    }

    //command for Alan showing it it's the buying screen
    void setVisualState() {
        JSONObject params = new JSONObject();
        try {
            params.put("screen","sell");
        } catch (JSONException e) {
            Log.e("AlanButton", e.getMessage());
        }
        alanButton.setVisualState(params.toString());
    }

    AlanCallback alanCallback = new AlanCallback() {
        /// Handle commands from Alan Studio
        @Override
        public void onCommand(final EventCommand eventCommand) {
            try {
                JSONObject command = eventCommand.getData();
                String commandName = command.getJSONObject("data").getString("command");
                String commandText = command.getJSONObject("data").getString("value");
                Log.d("AlanButton", "onCommand: commandName: " + commandName);
                if ("priceText".equals(commandName)) {
                    priceText.setText(commandText);
                }else if("getMake".equals(commandName)){
                    makeText.setText(commandText);
                }else if("getModel".equals(commandName)){
                    modelText.setText(commandText);
                }else if("getMillage".equals(commandName)){
                    millageText.setText(commandText);
                }else if(!priceText.equals("")&&!modelText.equals("")&&!makeText.equals("")&&!millageText.equals("")){
                    Toast.makeText(SellCar.this, "For Image of vehicle URL you have to input it manually", Toast.LENGTH_SHORT).show();
                }
                else {
                    Log.d("AlanButton", "Unknown event");
                }
            } catch (JSONException e) {
                Log.e("AlanButton", e.getMessage());
            }
        }
    };

}