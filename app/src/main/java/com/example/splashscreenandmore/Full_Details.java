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

        slideModels.add(new SlideModel("https://c4.wallpaperflare.com/wallpaper/500/442/354/outrun-vaporwave-hd-wallpaper-preview.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://c4.wallpaperflare.com/wallpaper/108/140/869/digital-digital-art-artwork-fantasy-art-drawing-hd-wallpaper-preview.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://c4.wallpaperflare.com/wallpaper/946/379/721/artwork-landscape-mountains-forest-wallpaper-preview.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://c4.wallpaperflare.com/wallpaper/846/616/937/digital-digital-art-artwork-illustration-drawing-hd-wallpaper-preview.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://c4.wallpaperflare.com/wallpaper/816/451/655/sphere-art-artwork-1980s-wallpaper-preview.jpg", ScaleTypes.FIT));

        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        // I have some imageurls which i will use in this slider.

        //we didnt add INTERNET permission in Manifest :)

        //Thanks for watvhing the video, Keep sharing and subscribe the channel :)
/*
        ref= FirebaseDatabase.getInstance().getReference().child("Vehicles");
        carTitle.findViewById(R.id.speedo);

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