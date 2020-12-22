package com.example.farmacia2.App;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MyApp extends Application {
    public static SharedPreferences preferences;
    @Override
    public void onCreate() {
        super.onCreate();
      preferences = getSharedPreferences("preferences", Context.MODE_PRIVATE);
      Medicamento.CargaInicial();
      SystemClock.sleep(10);
    }

}
