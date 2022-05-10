package com.example.splashscreenandmore;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class LoginTabFragement extends Fragment{
    TextView email;
    TextView password;
    TextView forgetPass;
    Button login;
    float v=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        ViewGroup root=(ViewGroup) inflater.inflate(R.layout.login_tab_fragment, container,false);


        email = root.findViewById(R.id.email);
        password= root.findViewById(R.id.password);
        forgetPass= root.findViewById(R.id.forgetPass);
        login= root.findViewById(R.id.loginButton);

        email.setTranslationX(800);
        password.setTranslationX(800);
        forgetPass.setTranslationX(800);
        login.setTranslationX(800);

        email.setAlpha(v);
        password.setAlpha(v);
        forgetPass.setAlpha(v);
        login.setAlpha(v);

        email.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(300).start();
        password.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        forgetPass.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(300).start();
        login.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(700).start();
        return root;
    }
}
