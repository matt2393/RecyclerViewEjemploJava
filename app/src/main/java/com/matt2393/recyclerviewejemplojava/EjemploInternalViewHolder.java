package com.matt2393.recyclerviewejemplojava;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EjemploInternalViewHolder extends RecyclerView.ViewHolder {
    public TextView text1,text2,text3, textDetalles;

    public EjemploInternalViewHolder(@NonNull View itemView) {
        super(itemView);
        text1=itemView.findViewById(R.id.text_1);
        text2=itemView.findViewById(R.id.text_2);
        text3=itemView.findViewById(R.id.text_3);
        textDetalles=itemView.findViewById(R.id.text_detalles);
    }
}
