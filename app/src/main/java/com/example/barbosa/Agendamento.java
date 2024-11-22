package com.example.barbosa;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

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

        Bundle intent = getIntent().getExtras();
        String barberId = intent != null ? intent.getString("barberId") : null;

        SharedPreferences sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
        String userId = sharedPreferences.getString("id", null);

        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        Button btnConfirmar = findViewById(R.id.btnConfirmarAgendamento);

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (barberId != null && userId != null) {
                    confirmarAgendamento(Integer.parseInt(barberId), Integer.parseInt(userId));
                } else {
                    Toast.makeText(Agendamento.this, "Erro ao recuperar dados do usuário ou barbeiro.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void confirmarAgendamento(int barberId, int userId) {
        String startDate = formatDate(datePicker, timePicker);

        timePicker.setHour(timePicker.getHour() + 1);
        String endDate = formatDate(datePicker, timePicker);

        AgendamentoDTO agendamentoDTO = new AgendamentoDTO(userId, barberId, startDate, startDate, endDate);

        String token = getToken();
        AgendamentoService service = new AgendamentoService(token);
        CompletableFuture<Response> response = service.agendar(agendamentoDTO);

        response.whenComplete((res, err) -> {
            if (err != null) {
                runOnUiThread(() -> {
                    Toast.makeText(this, "Erro ao agendar: " + err.getMessage(), Toast.LENGTH_SHORT).show();
                });
                return;
            }

            runOnUiThread(() -> {
                if (res.code() == 201) {
                    Toast.makeText(this, "Agendamento realizado com sucesso!", Toast.LENGTH_SHORT).show();
                    redirecionarParaHome();
                } else {
                    Toast.makeText(this, "Erro ao agendar. Tente novamente.", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }

    private String formatDate(DatePicker datePicker, TimePicker timePicker) {
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth() + 1;
        int year = datePicker.getYear();
        int hour = timePicker.getHour();
        int minute = timePicker.getMinute();

        return String.format("%04d-%02d-%02dT%02d:%02d:00.000Z", year, month, day, hour, minute);
    }

    private String getToken() {
        SharedPreferences sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
        return sharedPreferences.getString("token", null);
    }

    private void redirecionarParaHome() {
        Intent intent = new Intent(this, Home.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
