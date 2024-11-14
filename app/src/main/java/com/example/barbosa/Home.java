package com.example.barbosa;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Home extends AppCompatActivity {
    private TextView tvHello;
    private TextView tvDate;
    private Handler handler = new Handler();
    private Runnable runnable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!isUserLoggedIn()) {
            Intent loginIntent = new Intent(this, Login.class);
            startActivity(loginIntent);
            finish();
            return;
        }

        setContentView(R.layout.home);
        tvHello = findViewById(R.id.tvHello);
        tvDate = findViewById(R.id.tvDate); // Adicionando referência para tvDate

        SharedPreferences preferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
        String nomeCompleto = preferences.getString("user_name", "Usuário");

        if (nomeCompleto != null && !nomeCompleto.isEmpty()) {
            String[] nomes = nomeCompleto.split(" ");
            String saudacaoTexto = "Olá, " + nomes[0];
            SpannableString saudacao = new SpannableString(saudacaoTexto);

            saudacao.setSpan(new ForegroundColorSpan(Color.BLACK), 0, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            saudacao.setSpan(new ForegroundColorSpan(Color.parseColor("#142157")), 5, saudacaoTexto.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            tvHello.setText(saudacao);
        } else {
            tvHello.setText("Olá!");
        }

        // Configurar o Runnable para atualizar a data
        runnable = new Runnable() {
            @Override
            public void run() {
                updateDate(); // Atualiza a data
                handler.postDelayed(this, 1000); // Atualiza a cada segundo
            }
        };
        handler.post(runnable); // Inicia o Runnable

        LinearLayout userIcon = findViewById(R.id.userIcon);
        userIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent barbeariaIntent = new Intent(Home.this, Barbearia.class);
                startActivity(barbeariaIntent);
            }
        });
    }

    private void updateDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMM yyyy", new Locale("pt", "BR"));
        String currentDate = sdf.format(new Date());
        tvDate.setText(currentDate);
    }

    private boolean isUserLoggedIn() {
        SharedPreferences preferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
        return preferences.getBoolean("is_logged_in", false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable); // Remove o Runnable quando a Activity é destruída
    }
}
