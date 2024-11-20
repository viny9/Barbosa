package com.example.barbosa.domain.Auth;

import com.example.barbosa.domain.Auth.Dtos.LoginDTO;
import com.example.barbosa.domain.Auth.Dtos.LoginResponseDTO;
import com.example.barbosa.utils.HttpClient;
import com.example.barbosa.utils.JsonConverter;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import okhttp3.Response;

public class AuthService {
    public CompletableFuture<LoginResponseDTO> login(LoginDTO loginDTO) {
        final HttpClient<LoginDTO> http = new HttpClient<LoginDTO>();

        CompletableFuture<Response> response = http.post("/auth", loginDTO);

        CompletableFuture<LoginResponseDTO> dtoResponse = response.thenApply((res) -> {
            LoginResponseDTO dto = null;

            try {
                String body = res.body().string();
                dto = JsonConverter.reverter(body, LoginResponseDTO.class);
            } catch (IOException e) {
                System.out.println(e);
            }

            return dto;
        });
        return dtoResponse;
    }
}


