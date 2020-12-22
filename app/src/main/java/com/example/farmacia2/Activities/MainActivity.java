package com.example.farmacia2.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.farmacia2.App.MyApp;
import com.example.farmacia2.R;
import com.example.farmacia2.Utils.Utils;

public class MainActivity extends AppCompatActivity {
  //  private SharedPreferences preferences;
    private Button buttonDosis;
    private Button buttonTratamiento;
    private Button buttonInventario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // mostrar Icono
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_farma);

        setTitle("Mi Farmacia");

      //  preferences = getSharedPreferences("preferences", Context.MODE_PRIVATE);
        buttonDosis = findViewById(R.id.buttonDosis);
        buttonTratamiento = findViewById(R.id.buttonTratamiento);
        buttonInventario = findViewById(R.id.buttonInventario);

        buttonDosis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DosisActivity.class);
                startActivity(intent);
            }
        });

        buttonTratamiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TratamientoActivity.class);
                startActivity(intent);
            }
        });


        // FALTA DARLE FUNCIONALIDAD
        buttonInventario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

       //         Intent intent = new Intent(MainActivity.this, DosisActivity.class);
        //        startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_logout:
                logOut();
                return true;
            case R.id.menu_forget:
                removeSharePreferences();
                logOut();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Borrar el contenido del preferences
     */
    private void removeSharePreferences() {
        //preferences.edit().clear().apply();
        Utils.removeEmailPreferences(MyApp.preferences);
        Utils.removePasswordPreferences(MyApp.preferences);
    }


    /**
     * Vamos al loginActivity pero como una nueva tarea
     */
    private void logOut() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}