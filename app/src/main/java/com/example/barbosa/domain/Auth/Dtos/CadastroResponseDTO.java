package com.example.barbosa.domain.Auth.Dtos;

public class CadastroResponseDTO {
    private String message;
    private int userId; // Exemplo: ID do usuário recém-criado
    private boolean success;

    public String getMessage() {
        return message;
    }

    public int getUserId() {
        return userId;
    }

    public boolean isSuccess() {
        return success;
    }
}
