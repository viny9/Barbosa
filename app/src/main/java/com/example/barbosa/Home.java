package com.example.barbosa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class Home extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.home);
    }

    public void cadastrar(View view){
        Intent cadastro = new Intent(this,Cadastro.class);
        startActivity(cadastro);

    }

}
