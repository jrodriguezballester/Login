package com.example.farmacia2.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.farmacia2.Adapter.AdapterTratamiento;
import com.example.farmacia2.App.Medicamento;
import com.example.farmacia2.App.MyApp;
import com.example.farmacia2.R;
import com.example.farmacia2.Utils.Utils;



public class TratamientoActivity extends AppCompatActivity {
    private EditText editTextNombre;
    private EditText editTextDosis;
    private Button buttonAdd;
    private String nombre;
    private String dosis;
    private ListView listViewMedicamento;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tratamiento);

        editTextNombre=findViewById(R.id.editTextNombreMedicina);
        editTextDosis=findViewById(R.id.editTextDosis);
        buttonAdd=findViewById(R.id.buttonAdd);
        listViewMedicamento=findViewById(R.id.listViewMedicamento);

        // mostrar Icono
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_farma);

        // mostrar Up
        getSupportActionBar().setHomeButtonEnabled(true);


        AdapterTratamiento tratamientoAdapter;
// Inicializamos el adapter.

        tratamientoAdapter = new AdapterTratamiento(this, Medicamento.listaMedicamentos);

        listViewMedicamento.setAdapter(tratamientoAdapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre=editTextNombre.getText().toString();
                dosis=editTextDosis.getText().toString();
                // guardar medicamento
                Medicamento medicamento=new Medicamento(nombre,dosis);
                Medicamento.listaMedicamentos.add(medicamento);
                tratamientoAdapter.notifyDataSetChanged();
                Utils.saveListaMedicamentosShare(MyApp.preferences);
            }
        });
    }
}