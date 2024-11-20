package com.example.barbosa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.barbosa.domain.Auth.AuthService;
import com.example.barbosa.domain.Auth.Dtos.LoginDTO;
import com.example.barbosa.domain.Auth.Dtos.LoginResponseDTO;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public class Login extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        TextView cadastroLink = findViewById(R.id.cadastroLink);
        cadastroLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cadastro = new Intent(Login.this, Cadastro.class);
                startActivity(cadastro);
            }
        });

        Button btnEntrar = findViewById(R.id.btnLogin);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    login(v);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private void login(View view) throws IOException {
        EditText email = findViewById(R.id.loginEmail);
        EditText password = findViewById(R.id.loginSenha);

        if (email.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
            TextView erro = findViewById(R.id.alertaLogin);
            erro.setText("Por favor, preencha todos os campos.");
            return;
        }

        LoginDTO loginDTO = new LoginDTO(email.getText().toString(), password.getText().toString());
        CompletableFuture<LoginResponseDTO> loginResponseDto = new AuthService().login(loginDTO);

        loginResponseDto.whenComplete((res, err) -> {
            if (err != null) {
                TextView erro = findViewById(R.id.alertaLogin);
                erro.setText("Erro de autenticação. Verifique seus dados.");
                return;
            }

            Intent home = new Intent(this, Home.class);
            startActivity(home);
        });
    }
}
