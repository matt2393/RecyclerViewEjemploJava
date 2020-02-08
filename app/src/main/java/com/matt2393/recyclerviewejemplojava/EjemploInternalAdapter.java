package com.matt2393.recyclerviewejemplojava;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EjemploInternalAdapter extends RecyclerView.Adapter<EjemploInternalViewHolder> {

    private ArrayList<Datos> datos;

    public EjemploInternalAdapter(ArrayList<Datos> datos) {
        this.datos = datos;
    }

    @NonNull
    @Override
    public EjemploInternalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EjemploInternalViewHolder(
                LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_internal,parent,false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull EjemploInternalViewHolder holder, int position) {
        final Datos dato=datos.get(position);
        holder.text1.setText(dato.getNum_ot());
        holder.text2.setText(dato.getNum_ot_id());
        holder.text3.setText(dato.getStatus_type());
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }
}
