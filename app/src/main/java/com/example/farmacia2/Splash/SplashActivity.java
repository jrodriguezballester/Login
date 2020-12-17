package com.example.farmacia2.Splash;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.farmacia2.Activities.LoginActivity;
import com.example.farmacia2.Activities.MainActivity;
import com.example.farmacia2.Utils.Utils;

public class SplashActivity extends AppCompatActivity {
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences = getSharedPreferences("preferences", Context.MODE_PRIVATE);

        Intent intentLogin = new Intent(this, LoginActivity.class);
        Intent intentMain = new Intent(this, MainActivity.class);

        if (!Utils.IsValidEmail(Utils.getEmailPreferences(preferences))
                && !Utils.IsValidPassWord(Utils.getPasswordPreferences(preferences))) {
            startActivity(intentLogin);
        } else {
            startActivity(intentMain);
        }
        finish();

    }
}