package com.example.barbosa;

import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;



import androidx.recyclerview.widget.RecyclerView;

import com.example.barbosa.domain.Barber.Barber;

public class BarbeiroViewHolder extends RecyclerView.ViewHolder {
    public BarbeiroViewHolder(View itemView) {
        super(itemView);
    }

    public void bind(Barber barber) {
        TextView barberName = itemView.findViewById(R.id.barberName);
        TextView barberSpecialities = itemView.findViewById(R.id.barberSpecialities);
        Button btnAgendar = itemView.findViewById(R.id.btnAgendar);

        barberName.setText(barber.getName());
        barberSpecialities.setText(barber.getSpecialities());

        btnAgendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Agendamento.class);
                v.getContext().startActivity(intent);
            }
        });
    }

}
