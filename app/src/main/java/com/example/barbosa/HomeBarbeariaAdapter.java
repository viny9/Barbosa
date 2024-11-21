package com.example.barbosa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.barbosa.domain.BarberShop.BarberShop;

import java.util.List;

public class HomeBarbeariaAdapter extends RecyclerView.Adapter<HomeBarbeariaViewHolder> {

    private List<BarberShop> barbearias;

    public HomeBarbeariaAdapter(List<BarberShop> barbearias) {
        this.barbearias = barbearias;
    }

    @Override
    public HomeBarbeariaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_barbearia, parent, false);
        return new HomeBarbeariaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HomeBarbeariaViewHolder holder, int position) {
        BarberShop barbearia = barbearias.get(position);
        holder.bind(barbearia);
    }

    @Override
    public int getItemCount() {
        return barbearias.size();
    }

}

