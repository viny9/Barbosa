package com.example.barbosa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Cadastro extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.cadastro);

        // Configurar o link para voltar à página de login
        TextView voltarLogin = findViewById(R.id.voltarLogin);
        voltarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirecionar para a página de login
                Intent login = new Intent(Cadastro.this, Login.class);
                startActivity(login);
                finish(); // Finaliza a activity atual para não empilhar na navegação
            }
        });
    }

    public void cadastro(View view) {
        // Lógica do cadastro, se houver
    }
}
