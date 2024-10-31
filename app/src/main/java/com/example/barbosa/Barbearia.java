package com.example.barbosa;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.barbosa.domain.Barber;

import java.util.ArrayList;
import java.util.List;

public class Barbearia extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.barbearia);

        List<Barber> barbeiros = new ArrayList<Barber>();
        barbeiros.add(new Barber("barbar, cabelo", "Teste1"));
        barbeiros.add(new Barber("barbar, cabelo", "Teste2"));
        barbeiros.add(new Barber("barbar, cabelo, sobrancelhas", "Teste3"));

        RecyclerView recicleView = findViewById(R.id.barbersList);
        recicleView.setLayoutManager(new LinearLayoutManager(this));

        BarbeiroAdapter adapter = new BarbeiroAdapter(barbeiros);
        recicleView.setAdapter(adapter);

    }
}
