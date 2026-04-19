package com.crud.usuario.usuario.dtos;

public class UsuarioAtualizaDto {

    private String cpf;
    private String nome;
    private String login;

    public UsuarioAtualizaDto() {
    }

    public UsuarioAtualizaDto(String cpf, String nome, String login) {
        this.cpf = cpf;
        this.nome = nome;
        this.login = login;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
