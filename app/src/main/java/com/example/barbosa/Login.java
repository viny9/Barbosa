package com.example.barbosa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Login extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);
    }

    public void autenticar(View view){
        EditText login = findViewById(R.id.loginEmail);
        EditText senha = findViewById(R.id.loginSenha);

        LoginVO loginvo = new LoginVO();

        loginvo.setLogin(login.getText().toString());
        loginvo.setLogin(senha.getText().toString());

        if(loginvo.getLogin().equals("PauloHenrique")&& loginvo.getSenha().equals("980428")){
            Intent menu = new Intent(this,Menu.class);
            startActivity(menu);

        }



    }


}

