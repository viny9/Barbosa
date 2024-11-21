package com.example.barbosa.domain.Barber;

import com.example.barbosa.domain.Barber.Dtos.BarberDTO;
import com.example.barbosa.domain.User.User;

public class Barber {
    private int barberId;
    private int userId;
    private User user;

    public Barber(BarberDTO dto) {
        this.barberId = dto.getId();
        this.userId = dto.getUserId();
        this.user = dto.getUser();
    }

    public int getBarberId() {
        return barberId;
    }

    public int getUserId() {
        return userId;
    }

    public User getUser() {
        return user;
    }
}
