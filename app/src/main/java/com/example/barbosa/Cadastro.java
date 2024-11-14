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

public class Cadastro extends Activity {
    private EditText name;
    private EditText email;
    private EditText telefone;
    private EditText senha;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);

        name = findViewById(R.id.etNomeCompleto);
        email = findViewById(R.id.loginEmail);
        telefone = findViewById(R.id.etTelefone);
        senha = findViewById(R.id.loginSenha);

        Button btnCadastrar = findViewById(R.id.btnLogin);
        TextView voltarLogin = findViewById(R.id.voltarLogin);

        btnCadastrar.setOnClickListener(v -> salvarUsuario());

        voltarLogin.setOnClickListener(v -> {
            Intent intent = new Intent(Cadastro.this, Login.class);
            startActivity(intent);
            finish();
        });
    }

    private void salvarUsuario() {
        String nomeStr = name.getText().toString().trim();
        String emailStr = email.getText().toString().trim();
        String telefoneStr = telefone.getText().toString().trim();
        String senhaStr = senha.getText().toString().trim();

        if (nomeStr.isEmpty() || emailStr.isEmpty() || telefoneStr.isEmpty() || senhaStr.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPreferences sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user_name", nomeStr); // Armazenando o nome completo
        editor.putString("user_email", emailStr);
        editor.putString("user_telefone", telefoneStr);
        editor.putString("user_senha", senhaStr);
        editor.putBoolean("is_logged_in", true); // Marque o usuário como logado
        editor.apply();

        Toast.makeText(this, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show();

        Intent loginIntent = new Intent(Cadastro.this, Login.class);
        startActivity(loginIntent);
        finish();
    }
}
