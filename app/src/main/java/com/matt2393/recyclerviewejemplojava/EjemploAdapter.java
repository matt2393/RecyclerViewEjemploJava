package com.matt2393.recyclerviewejemplojava;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class EjemploAdapter extends RecyclerView.Adapter<EjemploViewHolder> {

    private ArrayList<Otro> otros;
    private FragmentActivity fragmentActivity;

    public EjemploAdapter(ArrayList<Otro> otros, FragmentActivity fragmentActivity) {
        this.otros = otros;
        this.fragmentActivity = fragmentActivity;
    }

    @NonNull
    @Override
    public EjemploViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EjemploViewHolder(
                LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ejemplo, parent,false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull EjemploViewHolder holder, int position) {
        final Otro ot = otros.get(position);
        holder.textTitulo.setText(ot.getFecha());
        holder.recycler.setLayoutManager(new LinearLayoutManager(fragmentActivity));
        holder.recycler.setAdapter(new EjemploInternalAdapter(ot.getDatos()));
    }

    @Override
    public int getItemCount() {
        return otros.size();
    }

    public void setOtros(ArrayList<Otro> otros) {
        this.otros = otros;
    }
}
