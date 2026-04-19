package com.crud.usuario.usuario.dtos;

import com.crud.usuario.usuario.entitys.UsuarioEntity;

public class UsuarioSaidaDto {

    private String cpf;
    private String nome;
    private String login;

    public UsuarioSaidaDto() {
    }

    public UsuarioSaidaDto(String cpf, String nome, String login) {
        this.cpf = cpf;
        this.nome = nome;
        this.login = login;
    }

    //--Construtor para transforma (Entity - Dto) da classe UsuarioAtualizaDto.
    public UsuarioSaidaDto(UsuarioEntity entity) {
        this.cpf = entity.getCpf();
        this.nome = entity.getNome();
        this.login = entity.getLogin();
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
