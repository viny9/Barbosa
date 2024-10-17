package com.example.barbosa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Login extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // Configurar o link para a página de cadastro
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
                autenticar(v);
            }
        });
    }

    public void autenticar(View view) {
        EditText login = findViewById(R.id.loginEmail);
        EditText senha = findViewById(R.id.loginSenha);

        if (login.getText().toString().isEmpty() || senha.getText().toString().isEmpty()) {
            TextView erro = findViewById(R.id.alertaLogin);
            erro.setText("Por favor, preencha todos os campos.");
            return;
        }

        LoginVO loginvo = new LoginVO();
        loginvo.setLogin(login.getText().toString());
        loginvo.setSenha(senha.getText().toString());

        if (loginvo.getLogin().equals("phdeoliveirra@gmail.com") && loginvo.getSenha().equals("980428")) {
            Intent home = new Intent(this, Home.class);
            startActivity(home);
        } else {
            TextView erro = findViewById(R.id.alertaLogin);
            erro.setText("Erro de autenticação. Verifique seus dados.");
        }
    }
}
