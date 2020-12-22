package com.example.farmacia2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.farmacia2.Activities.TratamientoActivity;
import com.example.farmacia2.App.Medicamento;
import com.example.farmacia2.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterTratamiento extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Medicamento> medicamentos;


    public AdapterTratamiento(Context context, ArrayList<Medicamento> listaMedicamentos) {
        this.context = context;
        this.medicamentos = listaMedicamentos;
    }

    @Override
    public int getCount() {
        return medicamentos.size();
    }

    @Override
    public Object getItem(int position) {
        return medicamentos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(R.layout.list_item, null);

        TextView nombre = (TextView) item.findViewById(R.id.nombre);
        nombre.setText(medicamentos.get(position).getNombre());

        TextView dosis = (TextView) item.findViewById(R.id.dosis);
        dosis.setText(medicamentos.get(position).getDosis());

        return item;
    }
}
