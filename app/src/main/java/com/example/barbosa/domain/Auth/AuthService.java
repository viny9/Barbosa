package com.example.barbosa.domain.Auth;

import android.content.Intent;

import androidx.annotation.NonNull;

import com.example.barbosa.Home;
import com.example.barbosa.domain.Auth.Dtos.LoginDTO;
import com.example.barbosa.domain.Auth.Dtos.LoginResponseDTO;
import com.example.barbosa.models.ResponseCallback;
import com.example.barbosa.utils.HttpClient;
import com.example.barbosa.utils.JsonConverter;

import java.io.IOException;

import okhttp3.Response;

public class AuthService {
    public String login(LoginDTO loginDTO) throws IOException {
        final HttpClient<LoginDTO> http = new HttpClient<LoginDTO>();

        http.post("/auth", loginDTO, callback());
        return "";
    }

    private ResponseCallback callback() {
        return new ResponseCallback() {
            @Override
            public void onFailure(@NonNull IOException e) {
                System.out.println("Teste");
            }

            @Override
            public void onResponse(@NonNull Response response) {
                try {
                    String body = response.body().string();
                    LoginResponseDTO res = JsonConverter.reverter(body, LoginResponseDTO.class);
                    Intent home = new Intent(this, Home.class);
                    startActivity(home);
                } catch (IOException e) {
                    System.out.println("Teste");
                }
            }
        };
    }
}
