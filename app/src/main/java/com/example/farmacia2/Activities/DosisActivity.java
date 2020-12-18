package com.example.farmacia2.Activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.farmacia2.App.Medicamento;
import com.example.farmacia2.R;
import com.example.farmacia2.Utils.Utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.List;

public class DosisActivity extends AppCompatActivity {
    LinearLayout contenedorDesayuno;
    LinearLayout contenedorComida;
    LinearLayout contenedorCena;
    JSONArray jsonArray;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosis);

        // mostrar Icono
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_farma);

        // mostrar Up
        getSupportActionBar().setHomeButtonEnabled(true);

        preferences = getSharedPreferences("preferences", Context.MODE_PRIVATE);

        contenedorDesayuno = findViewById(R.id.contenedorDesayuno);
        contenedorComida = findViewById(R.id.contenedorComida);
        contenedorCena = findViewById(R.id.contenedorCena);

        setTitle("Pastillas");

        //Obtener los datos del SharePreferences
        String medicamentosJSONString = Utils.getJSONPreferences(preferences);

        //Convierte JSONArray a Lista de Objetos!
        Type type = new TypeToken<List<Medicamento>>(){}.getType();
        List<Medicamento> listaMedicamentos = new Gson().fromJson(medicamentosJSONString, type);

        // Pintar la lista dinamicamente
        for (Medicamento medicamento : listaMedicamentos) {
            String[] parts = medicamento.getDosis().split("");
            if (parts[0].equals("1")) {
                TextView textView = new TextView(getApplicationContext());
                textView.setText(medicamento.getNombre());
                textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                textView.setTextSize(18);
                contenedorDesayuno.addView(textView);
            }
            if (parts[1].equals("1")) {
                TextView textView = new TextView(getApplicationContext());
                textView.setText(medicamento.getNombre());
                textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                textView.setTextSize(18);
                contenedorComida.addView(textView);
            }
            if (parts[2].equals("1")) {
                TextView textView = new TextView(getApplicationContext());
                textView.setText(medicamento.getNombre());
                textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                textView.setTextSize(18);
                contenedorCena.addView(textView);
            }
        }
    }
}