package com.example.barbosa.domain.Auth;

import com.example.barbosa.domain.Auth.Dtos.AgendamentoDTO;
import com.example.barbosa.utils.HttpClient;

import java.util.concurrent.CompletableFuture;

import okhttp3.Response;

public class AgendamentoService {
    private String token = null;

    public AgendamentoService() {
    }

    public AgendamentoService(String token) {
        this.token = token;
    }

    public CompletableFuture<Response> agendar(AgendamentoDTO agendamentoDTO) {
        final HttpClient<AgendamentoDTO> http = new HttpClient<>(token);
        return http.post("/schedule", agendamentoDTO);
    }
}
