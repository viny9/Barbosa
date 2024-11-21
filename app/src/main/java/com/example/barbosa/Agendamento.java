package com.example.barbosa;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.barbosa.domain.Auth.AgendamentoService;
import com.example.barbosa.domain.Auth.Dtos.AgendamentoDTO;

import java.util.concurrent.CompletableFuture;

import okhttp3.Response;

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
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth() + 1;
        int year = datePicker.getYear();
        int hour = timePicker.getHour();
        int minute = timePicker.getMinute();

        String date = String.format("%04d-%02d-%02dT%02d:%02d:00.000Z", year, month, day, hour, minute);
        // Ajuste os valores fixos de `userId` e `barberId` conforme necessário
        AgendamentoDTO agendamentoDTO = new AgendamentoDTO(1, 1, date, date, date);

        AgendamentoService service = new AgendamentoService();
        CompletableFuture<Response> response = service.agendar(agendamentoDTO);

        response.whenComplete((res, err) -> {
            if (err != null) {
                runOnUiThread(() -> Toast.makeText(this, "Erro ao agendar: " + err.getMessage(), Toast.LENGTH_SHORT).show());
                return;
            }

            if (res.code() == 200) {
                runOnUiThread(() -> Toast.makeText(this, "Agendamento realizado com sucesso!", Toast.LENGTH_SHORT).show());
            } else {
                runOnUiThread(() -> Toast.makeText(this, "Erro ao agendar. Tente novamente.", Toast.LENGTH_SHORT).show());
            }
        });
    }
}
