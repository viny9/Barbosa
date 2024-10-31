package com.example.barbosa;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.barbosa.domain.Barber;

public class BarbeiroViewHolder extends RecyclerView.ViewHolder {
    public BarbeiroViewHolder(View itemView) {
        super(itemView);
    }

    public void bind(Barber barber) {
        TextView barberName = itemView.findViewById(R.id.barberName);
        TextView barberSpecialities = itemView.findViewById(R.id.barberSpecialities);

        barberName.setText(barber.getName());
        barberSpecialities.setText(barber.getSpecialities());
    }

}
