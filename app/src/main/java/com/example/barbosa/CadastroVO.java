package com.example.barbosa;

public class CadastroVO {
    private String nome;
    private String email;
    private String telefone; // Altere para String
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() { // Altere o tipo de retorno para String
        return telefone;
    }

    public void setTelefone(String telefone) { // Altere o parâmetro para String
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
