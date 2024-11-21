package com.example.barbosa.domain.Auth;

import com.example.barbosa.domain.Auth.Dtos.AgendamentoDTO;
import com.example.barbosa.utils.HttpClient;

import java.util.concurrent.CompletableFuture;

import okhttp3.Response;

public class AgendamentoService {
    public CompletableFuture<Response> agendar(AgendamentoDTO agendamentoDTO) {
        final HttpClient<AgendamentoDTO> http = new HttpClient<>();
        return http.post("/schedule", agendamentoDTO);
    }
}
