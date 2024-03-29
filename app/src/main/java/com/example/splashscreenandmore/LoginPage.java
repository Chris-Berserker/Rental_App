package com.example.splashscreenandmore;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPage extends AppCompatActivity {
    public Button loginbutton;
    public Button signupbutton;
    TextInputEditText etLoginEmail;
    TextInputEditText etLoginPassword;
    public ImageButton fingerprint;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);




        signupbutton = (Button) findViewById(R.id.SignUpbutton);
        signupbutton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(LoginPage.this,SignupPage.class);
                startActivity(intent);
                Animatoo.animateSlideDown(LoginPage.this);
            }
        }));

        etLoginEmail= findViewById(R.id.email);
        etLoginPassword= findViewById(R.id.password);
        loginbutton= findViewById(R.id.loginButton);

        mAuth = FirebaseAuth.getInstance();

        loginbutton.setOnClickListener(view ->{
            loginUser();
        });

        fingerprint = findViewById(R.id.fingerprint_icon);
        fingerprint.setOnClickListener(view ->{
            startActivity(new Intent(LoginPage.this,FingerPrintAuthentication.class));
        });

    }

    private void loginUser(){
        String email = etLoginEmail.getText().toString();
        String password = etLoginPassword.getText().toString();


        if (TextUtils.isEmpty(email)) {
            etLoginEmail.setError("Email cannot be empty");
            etLoginEmail.requestFocus();
        } else if (TextUtils.isEmpty(password)) {
            etLoginPassword.setError("Password cannot be empty");
            etLoginPassword.requestFocus();
        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(LoginPage.this, "User log in successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginPage.this, Loading.class));
                    }else{
                        Toast.makeText(LoginPage.this, "Log in Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}