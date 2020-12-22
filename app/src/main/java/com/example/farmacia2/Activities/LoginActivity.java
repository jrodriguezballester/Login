package com.example.farmacia2.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.farmacia2.App.MyApp;
import com.example.farmacia2.R;
import com.example.farmacia2.Utils.Utils;

public class LoginActivity extends AppCompatActivity {
    private Button btnLogin;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Switch switchRemember;
   // private SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Titulo
        setTitle("Farmacia - Login");
        //icono
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_farma);
        // crear el archivo preferences
     //   preferences = getSharedPreferences("preferences", Context.MODE_PRIVATE);


        // asociar Valores interface Grafica
        bindUI();
        // recoger valores del preferences
        setCredencialsIfExists();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                String pass = editTextPassword.getText().toString();
                boolean logeado = login(email, pass);
                if (logeado) {
                    goToMain();
                    if (switchRemember.isChecked()) {
                        saveOnPreferences(email, pass);
                    }
                }
            }
        });
    }


    /**
     * Asociar variables Java a Elementos Interface Grafica
     */
    private void bindUI() {
        btnLogin = findViewById(R.id.buttonLogin);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        switchRemember = findViewById(R.id.switchRemember);
    }


    /**
     * Devuelve True si email y password son validados; sino muestra mensajes de error
     *
     * @param email
     * @param pass
     * @return
     */
    private boolean login(String email, String pass) {
        if (!Utils.IsValidEmail(email)) {
            Toast.makeText(LoginActivity.this, "email is not valid", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!Utils.IsValidPassWord(pass)) {
            Toast.makeText(this, "password is not valid, 4 characters or more", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    /**
     * Inicia MainActivity; Impide la vuelta al loginActivity
     */
    private void goToMain() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    /**
     * Guardar email,pass en SharePreferences;
     *
     * @param email
     * @param pass
     */
    private void saveOnPreferences(String email, String pass) {
        SharedPreferences.Editor editor = MyApp.preferences.edit();
        editor.putString("EMAIL", email);
        editor.putString("PASS", pass);
        // editor.commit(); // [bloqueante y síncrono]
        editor.apply(); // [no bloqueante y asíncrono]
    }

    /**
     * Rellena los editText con los valores de preferences
     */
    private void setCredencialsIfExists() {
        String email = Utils.getEmailPreferences(MyApp.preferences);
        String password =Utils.getPasswordPreferences(MyApp.preferences);
        //  Toast.makeText(this, "e"+email+"-"+password, Toast.LENGTH_SHORT).show();
        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
            editTextEmail.setText(email);
            editTextPassword.setText(password);
        }
    }

}

