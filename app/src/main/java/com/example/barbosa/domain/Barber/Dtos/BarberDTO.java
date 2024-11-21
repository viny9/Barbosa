package com.example.barbosa.domain.Barber.Dtos;

import com.example.barbosa.domain.User.User;

public class BarberDTO {
    private int id;
    private int barberShopId;
    private int userId;
    private User user;

    public int getId() {
        return id;
    }

    public int getBarberShopId() {
        return barberShopId;
    }

    public int getUserId() {
        return userId;
    }

    public User getUser() {
        return user;
    }
}
