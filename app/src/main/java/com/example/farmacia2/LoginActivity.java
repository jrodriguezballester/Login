package com.example.farmacia2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button btnLogin;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Switch switchRemember;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // asociar Valores interface Grafica
        bindUI();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(LoginActivity.this, "Hola", Toast.LENGTH_LONG).show();
                String email = editTextEmail.getText().toString();
                String pass = editTextPassword.getText().toString();
               login(email,pass);
            }
        });

    }

    /**
     * Asociar variables Java a Elementos Interface Grafica
     */
    private void bindUI(){
        btnLogin=findViewById(R.id.buttonLogin);
        editTextEmail =findViewById(R.id.editTextEmail);
        editTextPassword=findViewById(R.id.editTextPassword);
        switchRemember =findViewById(R.id.switchRemember);
    }

    /**
     * Devuelve True si el parametro no esta vacio y cumple la expresion regular de Email
     * @param email
     * @return
     */
    private boolean IsValidEmail(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    /**
     * Devuelve True si tiene mas de 4 caracteres
     * @param password
     * @return
     */
    private boolean IsValidPassWord(String password) {
        return password.length() > 4;
    }

    /**
     * Devuelve True si email y password son validados; sino muestra mensajes de error
     * @param email
     * @param pass
     * @return
     */
    private boolean login(String email, String pass) {
        if (!IsValidEmail(email)) {
            Toast.makeText(LoginActivity.this, "email is not valid", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!IsValidPassWord(pass)) {
            Toast.makeText(this, "password is not valid, 4 characters or more", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }


}