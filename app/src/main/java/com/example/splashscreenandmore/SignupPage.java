package com.example.splashscreenandmore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupPage extends AppCompatActivity {
    public Button loginbutton;
    Button signupbutton;
    TextInputEditText etRegMail;
    TextInputEditText etRegPassword;
    TextInputEditText etRegUsername;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);


        loginbutton = (Button) findViewById(R.id.loginButton);
        loginbutton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupPage.this, LoginPage.class);
                startActivity(intent);
                Animatoo.animateSlideUp(SignupPage.this);
            }
        }));

        mAuth = FirebaseAuth.getInstance();
        etRegMail = findViewById(R.id.email);
        etRegPassword = findViewById(R.id.password);
        etRegUsername = findViewById(R.id.username);
        signupbutton = findViewById(R.id.SignUpbutton);

        signupbutton.setOnClickListener(view -> {
            createUser();
        });


    }


    private void createUser() {
        String email = etRegMail.getText().toString();
        String password = etRegPassword.getText().toString();
        String username = etRegUsername.getText().toString();

        if (TextUtils.isEmpty(email)) {
            etRegMail.setError("Email cannot be empty");
            etRegMail.requestFocus();
        } else if (TextUtils.isEmpty(password)) {
            etRegPassword.setError("Password cannot be empty");
            etRegPassword.requestFocus();
        } else if (TextUtils.isEmpty(username)) {
            etRegUsername.setError("Username cannot be empty");
            etRegUsername.requestFocus();
        } else {
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(SignupPage.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignupPage.this, LoginPage.class));
                    } else {
                        Toast.makeText(SignupPage.this, "Registration Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    }

