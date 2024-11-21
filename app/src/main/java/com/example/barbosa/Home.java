package com.example.barbosa;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.barbosa.domain.BarberShop.BarberShopService;

public class Home extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        listBarberShops();
    }

    private void listBarberShops() {
        String token = getToken();
        new BarberShopService(token).getAllBarberShops().whenComplete((res, err) -> {

            if (err != null) {
                err.printStackTrace();
                return;
            }

            runOnUiThread(() -> {
                RecyclerView recyclerView = findViewById(R.id.barberShopsList);
                LinearLayoutManager layoutManager = new LinearLayoutManager(this);
                layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(layoutManager);

                HomeBarbeariaAdapter adapter = new HomeBarbeariaAdapter(res);
                recyclerView.setAdapter(adapter);
            });
        });
    }

    private String getToken() {
        SharedPreferences sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
        String token = sharedPreferences.getString("token", null);
        return token;
    }
}
