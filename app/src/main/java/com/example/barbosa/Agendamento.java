package com.example.barbosa;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Agendamento extends Activity {

    private DatePicker datePicker;
    private TimePicker timePicker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agendamento);

        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        Button btnConfirmar = findViewById(R.id.btnConfirmarAgendamento);

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmarAgendamento();
            }
        });
    }

    private void confirmarAgendamento() {
        int dia = datePicker.getDayOfMonth();
        int mes = datePicker.getMonth() + 1;
        int ano = datePicker.getYear();
        int hora = timePicker.getHour();
        int minuto = timePicker.getMinute();

        String agendamento = "Agendado para: " + dia + "/" + mes + "/" + ano + " às " + hora + ":" + minuto;
        Toast.makeText(this, agendamento, Toast.LENGTH_SHORT).show();
        // Aqui você pode implementar a lógica para salvar o agendamento no servidor
    }
}
