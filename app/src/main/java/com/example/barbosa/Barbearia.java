package com.example.barbosa;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.barbosa.domain.BarberShop.BarberShopService;

public class Barbearia extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.barbearia);

        Bundle intent = getIntent().getExtras();
        String id = intent.getString("id");

        getBarberShopInfos(id);
        getBarberShopBarbers(id);
    }

    private void getBarberShopInfos(String id) {
        String token = getToken();
        new BarberShopService(token).getBarberShopById(id).whenComplete((res, err) -> {
            runOnUiThread(() -> {
                TextView barberShopName = findViewById(R.id.baberShopName);
                TextView barberShopLocation = findViewById(R.id.barberShopLocation);

                barberShopName.setText(res.getName());
                barberShopLocation.setText(res.getLocation());
            });
        });
    }

    private void getBarberShopBarbers(String id) {
        String token = getToken();
        new BarberShopService(token).getBarberShopBarbersById(id).whenComplete((res, err) -> {
            if (err != null) {
                err.printStackTrace();
                return;
            }

            runOnUiThread(() -> {
                RecyclerView recicleView = findViewById(R.id.barbersList);
                recicleView.setLayoutManager(new LinearLayoutManager(this));

                BarbeiroAdapter adapter = new BarbeiroAdapter(res);
                recicleView.setAdapter(adapter);
            });
        });
    }

    private String getToken() {
        SharedPreferences sharedPreferences = getSharedPreferences("token_save", MODE_PRIVATE);
        String token = sharedPreferences.getString("token", null);
        return token;
    }
}
