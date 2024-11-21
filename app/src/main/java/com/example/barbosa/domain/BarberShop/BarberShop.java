package com.example.barbosa.domain.BarberShop;

public class BarberShop {
    private int id;
    private String name;
    private String location;
    private String openAt;
    private String closeAt;

    public BarberShop(int id, String name, String location, String openAt, String closeAt) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.openAt = openAt;
        this.closeAt = closeAt;
    }

    public BarberShop(String name, String location, String openAt, String closeAt) {
        this.name = name;
        this.location = location;
        this.openAt = openAt;
        this.closeAt = closeAt;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getOpenAt() {
        return openAt;
    }

    public String getCloseAt() {
        return closeAt;
    }
}
