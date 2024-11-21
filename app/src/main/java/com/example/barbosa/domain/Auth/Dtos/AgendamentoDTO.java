package com.example.barbosa.domain.Auth.Dtos;

public class AgendamentoDTO {
    private int userId;
    private int barberId;
    private String date;
    private String startAt;
    private String endAt;

    public AgendamentoDTO(int userId, int barberId, String date, String startAt, String endAt) {
        this.userId = userId;
        this.barberId = barberId;
        this.date = date;
        this.startAt = startAt;
        this.endAt = endAt;
    }

    public int getUserId() {
        return userId;
    }

    public int getBarberId() {
        return barberId;
    }

    public String getDate() {
        return date;
    }

    public String getStartAt() {
        return startAt;
    }

    public String getEndAt() {
        return endAt;
    }
}
