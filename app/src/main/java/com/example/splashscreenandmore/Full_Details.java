package com.example.splashscreenandmore;;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Full_Details extends AppCompatActivity {


    TextView carTitle;
    private ImageSlider imageSlider;

    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_details);

        imageSlider = findViewById(R.id.imageSlider);

        // now we will create a list for images

        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel("https://cdn.motor1.com/images/mgl/6EEZG/s1/2015-6098442015-mitsubishi-lancer-evolution-final-edition1.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://hips.hearstapps.com/roa.h-cdn.co/assets/16/37/1474040762-2016-lancer-evolution-fe-18.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://i.ytimg.com/vi/6aaILbw0Oxk/maxresdefault.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://tdrpmimages.azureedge.net/photos/import/202206/2519/5309/c9f1ccb5-a800-4b29-95b5-4e9d7ef162a3.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://visor.ph/wp-content/uploads/2021/08/EVO-X-MAIN4.jpg", ScaleTypes.FIT));

        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        // I have some imageurls which i will use in this slider.

        //we didnt add INTERNET permission in Manifest :)

        //Thanks for watvhing the video, Keep sharing and subscribe the channel :)
/*
        ref= FirebaseDatabase.getInstance().getReference().child("Vehicles");
        carTitle.findViewById(R.id.carTitle);

        String VehiclesKey = getIntent().getStringExtra("VehiclesKey");

        ref.child(VehiclesKey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String model = dataSnapshot.child("model").getValue().toString();

                    carTitle.setText(model);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


*/
    }
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
       startActivity(new Intent(Full_Details.this,BuyCar.class));
    }

}