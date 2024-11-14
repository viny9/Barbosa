package com.example.barbosa.domain.Auth.Dtos;

import com.example.barbosa.domain.User.User;

public class LoginResponseDTO {
    private User user;
    private String accessToken;

    public User getUser() {
        return user;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
