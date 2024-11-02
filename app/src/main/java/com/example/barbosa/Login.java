package com.example.barbosa;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;

public class Login extends Activity {
    private EditText email;
    private EditText senha;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        email = findViewById(R.id.loginEmail);
        senha = findViewById(R.id.loginSenha);
        Button btnLogin = findViewById(R.id.btnLogin);
        TextView linkCadastro = findViewById(R.id.cadastroLink);

        btnLogin.setOnClickListener(v -> autenticarUsuario());

        linkCadastro.setOnClickListener(v -> {
            Intent cadastroIntent = new Intent(Login.this, Cadastro.class);
            startActivity(cadastroIntent);
        });
    }

    private void autenticarUsuario() {
        String emailStr = email.getText().toString().trim();
        String senhaStr = senha.getText().toString().trim();

        if (emailStr.isEmpty() || senhaStr.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPreferences sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
        String storedEmail = sharedPreferences.getString("user_email", null);
        String storedSenha = sharedPreferences.getString("user_senha", null);

        if (emailStr.equals(storedEmail) && senhaStr.equals(storedSenha)) {
            Toast.makeText(this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show();
            Intent mainIntent = new Intent(Login.this, Home.class);
            startActivity(mainIntent);
            finish();
        } else {
            Toast.makeText(this, "Email ou senha incorretos", Toast.LENGTH_SHORT).show();
        }
    }
}
