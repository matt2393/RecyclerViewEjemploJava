package com.matt2393.recyclerviewejemplojava;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EjemploViewHolder extends RecyclerView.ViewHolder {

    public TextView textTitulo;
    public RecyclerView recycler;

    public EjemploViewHolder(@NonNull View itemView) {
        super(itemView);
        textTitulo = itemView.findViewById(R.id.text_title);
        recycler = itemView.findViewById(R.id.recycler_ejemplo);
    }
}
