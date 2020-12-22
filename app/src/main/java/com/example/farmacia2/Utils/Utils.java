package com.example.farmacia2.Utils;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Patterns;

import com.example.farmacia2.App.Medicamento;
import com.google.gson.Gson;

public class Utils {


    /**
     * Obtener el Email guardado en SharePreferences
     *
     * @return
     */
    public static String getEmailPreferences(SharedPreferences preferences) {
        return preferences.getString("EMAIL", "");
    }

    /**
     * Obtener el Password guardado en SharePreferences
     *
     * @return
     */
    public static String getPasswordPreferences(SharedPreferences preferences) {
        return preferences.getString("PASS", "");
    }
    /**
     * Obtener el Json guardado en SharePreferences
     *
     * @return
     */
    public static String getJSONPreferences(SharedPreferences preferences) {
        return preferences.getString("JSON", "");
    }

    /**
     * Borra el Email de ShavePreferences
     * @param preferences
     */
    public static void removeEmailPreferences(SharedPreferences preferences) {
        preferences.edit().remove("EMAIL").apply();
    }
    /**
     * Borra el Password de ShavePreferences
     * @param preferences
     */
    public static void removePasswordPreferences(SharedPreferences preferences) {
        preferences.edit().remove("PASS").apply();
    }



    /**
     * Devuelve True si el parametro no esta vacio y cumple la expresion regular de Email
     *
     * @param email
     * @return
     */
    public static boolean IsValidEmail(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    /**
     * Devuelve True si tiene mas de 4 caracteres
     *
     * @param password
     * @return
     */
    public static boolean IsValidPassWord(String password) {
        return password.length() > 3;
    }

    public static void saveListaMedicamentosShare(SharedPreferences preferences){
        //Crea un json a partir de la lista de objetos.
        String jsonMedicamentos = new Gson().toJson(Medicamento.listaMedicamentos);

        SharedPreferences.Editor editor = preferences.edit();
        //Guarda lista de objetos, en formato .json
        editor.putString("JSON", jsonMedicamentos);
        editor.apply();

    }

}
