package com.example.farmacia2.App;

import java.util.ArrayList;

public class Medicamento {
    private String nombre;
    private String dosis;
    public static ArrayList<Medicamento> listaMedicamentos;
    public Medicamento(String nombre, String dosis) {
        this.nombre = nombre;
        this.dosis = dosis;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public static void CargaInicial(){

        listaMedicamentos = new ArrayList<Medicamento>();
        listaMedicamentos.add(new Medicamento("Rexer", "001"));
        listaMedicamentos.add(new Medicamento("Venlafaxina", "100"));
        listaMedicamentos.add(new Medicamento("Escitalopram", "100"));
        listaMedicamentos.add(new Medicamento("Etumina", "001"));
        listaMedicamentos.add(new Medicamento("Dormodor", "001"));
        listaMedicamentos.add(new Medicamento("Lormetacepam", "001"));
        listaMedicamentos.add(new Medicamento("Tranxilium", "111"));

    }
}
