package com.example.barbosa.domain.BarberShop;

import com.example.barbosa.domain.Barber.Barber;
import com.example.barbosa.domain.Barber.Dtos.BarberDTO;
import com.example.barbosa.utils.HttpClient;
import com.example.barbosa.utils.JsonConverter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

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

    public CompletableFuture<BarberShop> getBarberShopById(String id) {
        HttpClient<BarberShop> httpClient = new HttpClient<>(token);

        CompletableFuture<BarberShop> convertedResponse = httpClient.get("/barber-shop/" + id).thenApply((res) -> {
            BarberShop barberShop = null;
            try {
                String body = res.body().string();
                barberShop = JsonConverter.reverter(body, BarberShop.class);
            } catch (IOException e) {
                System.out.println(e);
            }

            return barberShop;
        });

        return convertedResponse;
    }

    public CompletableFuture<List<Barber>> getBarberShopBarbersById(String id) {
        HttpClient<Barber> httpClient = new HttpClient<>(token);

        CompletableFuture<List<Barber>> convertedResponse = httpClient.get("/barber/barberShop/" + id).thenApply((res) -> {
            List<Barber> barbers = new ArrayList<>();
            try {
                String body = res.body().string();
                List<BarberDTO> dto = JsonConverter.reverterList(body, BarberDTO.class);
                barbers = dto.stream().map(Barber::new).collect(Collectors.toList());
                barbers.forEach((ba) -> System.out.println(ba.getUser().getName()));
            } catch (IOException e) {
                System.out.println(e);
            }

            return barbers;
        });

        return convertedResponse;
    }

}
