package com.example.barbosa.domain.Auth;

import com.example.barbosa.domain.Auth.Dtos.CadastroDTO;
import com.example.barbosa.utils.HttpClient;

import java.util.concurrent.CompletableFuture;

import okhttp3.Response;

public class CadastroService {
    public CompletableFuture<Response> cadastrarUsuario(CadastroDTO cadastroDTO) {
        final HttpClient<CadastroDTO> http = new HttpClient<>();
        return http.post("/auth/register", cadastroDTO);
    }
}
