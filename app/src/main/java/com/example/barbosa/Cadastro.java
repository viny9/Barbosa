package com.example.barbosa;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.barbosa.domain.Auth.CadastroService;
import com.example.barbosa.domain.Auth.Dtos.CadastroDTO;

import java.util.concurrent.CompletableFuture;

import okhttp3.Response;

public class Cadastro extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);

        // Botão para enviar os dados de cadastro
        Button btnCadastrar = findViewById(R.id.btnLogin);
        btnCadastrar.setText("Cadastrar");

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    cadastrarUsuario();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // Link para voltar ao login
        TextView voltarLogin = findViewById(R.id.voltarLogin);
        voltarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Voltar para a tela de login
            }
        });
    }

    private void cadastrarUsuario() {
        EditText nome = findViewById(R.id.etNomeCompleto);
        EditText email = findViewById(R.id.loginEmail);
        EditText telefone = findViewById(R.id.etTelefone);
        EditText senha = findViewById(R.id.loginSenha);

        // Validação básica
        if (nome.getText().toString().isEmpty() || email.getText().toString().isEmpty()
                || telefone.getText().toString().isEmpty() || senha.getText().toString().isEmpty()) {
            TextView erro = findViewById(R.id.alertaCadastro);
            erro.setText("Por favor, preencha todos os campos.");
            return;
        }

        CadastroDTO cadastroDTO = new CadastroDTO(
                nome.getText().toString(),
                email.getText().toString(),
                telefone.getText().toString(),
                senha.getText().toString()
        );

        CadastroService service = new CadastroService();
        CompletableFuture<Response> response = service.cadastrarUsuario(cadastroDTO);

        response.whenComplete((res, err) -> {
            if (err != null) {
                runOnUiThread(() -> {
                    TextView erro = findViewById(R.id.alertaCadastro);
                    erro.setText("Erro ao cadastrar. Tente novamente.");
                });
                return;
            }

            runOnUiThread(() -> {
                TextView sucesso = findViewById(R.id.alertaCadastro);
                sucesso.setText("Cadastro realizado com sucesso!");
                finish(); // Voltar para o login
            });
        });
    }
}
