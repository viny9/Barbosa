package com.example.barbosa.domain.BarberShop;

import com.example.barbosa.utils.HttpClient;
import com.example.barbosa.utils.JsonConverter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BarberShopService {
    private String token;

    public BarberShopService(String token) {
        this.token = token;
    }

    public CompletableFuture<List<BarberShop>> getAllBarberShops() {
        HttpClient<BarberShop> httpClient = new HttpClient<>(token);

        CompletableFuture<List<BarberShop>> convertedResponse = httpClient.get("/barber-shop").thenApply((res) -> {
            List<BarberShop> barberShops = new ArrayList<>();
            try {
                String body = res.body().string();
                barberShops = JsonConverter.reverterList(body, BarberShop.class);
            } catch (IOException e) {
                System.out.println(e);
            }

            return barberShops;
        });

        return convertedResponse;
    }

}
