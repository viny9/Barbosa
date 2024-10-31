package com.example.barbosa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.barbosa.domain.Barber;

import java.util.List;

public class BarbeiroAdapter extends RecyclerView.Adapter<BarbeiroViewHolder> {

    private List<Barber> barbeiros;

    public BarbeiroAdapter(List<Barber> barbeiros) {
        this.barbeiros = barbeiros;
    }

    @Override
    public BarbeiroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.barbeiro, parent, false);
        return new BarbeiroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BarbeiroViewHolder holder, int position) {
        Barber barbeiro = barbeiros.get(position);
        holder.bind(barbeiro);
    }

    @Override
    public int getItemCount() {
        return barbeiros.size();
    }

}
