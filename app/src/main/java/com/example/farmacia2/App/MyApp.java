package com.example.farmacia2.App;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ArrayList<Medicamento> listaMedicamentos = new ArrayList<Medicamento>();
        listaMedicamentos.add(new Medicamento("Rexer", "001"));
        listaMedicamentos.add(new Medicamento("Venlafaxina", "100"));
        listaMedicamentos.add(new Medicamento("Escitalopram", "100"));
        listaMedicamentos.add(new Medicamento("Etumina", "001"));
        listaMedicamentos.add(new Medicamento("Dormodor", "001"));
        listaMedicamentos.add(new Medicamento("Lormetacepam", "001"));
        listaMedicamentos.add(new Medicamento("Tranxilium", "111"));

        //Crea un json a partir de la lista de objetos.
        String jsonMedicamentos = new Gson().toJson(listaMedicamentos);

        SharedPreferences preferences;
        preferences = getSharedPreferences("preferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();


        //Guarda lista de objetos, en formato .json
        editor.putString("JSON", jsonMedicamentos);
        editor.apply();


        SystemClock.sleep(1000);
    }

}
