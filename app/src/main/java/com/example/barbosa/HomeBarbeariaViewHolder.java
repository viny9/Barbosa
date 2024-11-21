package com.example.barbosa;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.barbosa.domain.BarberShop.BarberShop;

public class HomeBarbeariaViewHolder extends RecyclerView.ViewHolder {
    public HomeBarbeariaViewHolder(View itemView) {
        super(itemView);
    }

    public void bind(BarberShop barbearia) {
        TextView barberShopName = itemView.findViewById(R.id.homeBarberShopName);
        LinearLayout barberShopItem = itemView.findViewById(R.id.barberShopItem);

        barberShopName.setText(barbearia.getName());

        barberShopItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Barbearia.class);
                v.getContext().startActivity(intent);
            }
        });
    }

}
