package com.fonzo.tfg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.fonzo.tfg.ui.login.LoginFragment;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.main_activity_fragment_host, new LoginFragment()).commit();
    }
}