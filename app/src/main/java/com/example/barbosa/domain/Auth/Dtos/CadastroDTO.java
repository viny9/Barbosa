package com.example.barbosa.domain.Auth.Dtos;

public class CadastroDTO {
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private String type;

    // Construtor com parâmetros
    public CadastroDTO(String name, String email, String phoneNumber, String password) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.type = "USER"; // Tipo padrão
    }

    // Getter e Setter para 'name'
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter e Setter para 'email'
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter e Setter para 'phoneNumber'
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Getter e Setter para 'password'
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter e Setter para 'type' (caso precise modificar o tipo futuramente)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
