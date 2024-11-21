package com.example.barbosa.domain.Auth.Dtos;

public class AgendamentoResponseDTO {
    private int id;
    private String startAt;
    private String endAt;
    private String date;
    private int userId;
    private int barberId;

    // Getters
    public int getId() {
        return id;
    }

    public String getStartAt() {
        return startAt;
    }

    public String getEndAt() {
        return endAt;
    }

    public String getDate() {
        return date;
    }

    public int getUserId() {
        return userId;
    }

    public int getBarberId() {
        return barberId;
    }
}
