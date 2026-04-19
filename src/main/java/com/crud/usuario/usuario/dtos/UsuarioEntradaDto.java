package com.crud.usuario.usuario.dtos;

public class UsuarioEntradaDto {


    private Long id;

    private String cpf;

    private String nome;

    private String login;

    private String senha;

    public UsuarioEntradaDto() {
    }

    public UsuarioEntradaDto(Long id, String cpf, String nome, String login, String senha) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
