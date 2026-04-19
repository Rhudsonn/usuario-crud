package com.crud.usuario.usuario.entitys;

import com.crud.usuario.usuario.dtos.UsuarioAtualizaDto;
import com.crud.usuario.usuario.dtos.UsuarioEntradaDto;
import jakarta.persistence.*;

@Entity
@Table(name = "USUARIO")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "nome")
    private String nome;

    @Column(name = "login")
    private String login;

    @Column(name = "senha")
    private String senha;

    //--Construtor para transforma (Dto - Entity) da classe UsuarioEntradaDto.
    public UsuarioEntity(UsuarioEntradaDto usuarioEntradaDto) {
        this.cpf = usuarioEntradaDto.getCpf();
        this.nome = usuarioEntradaDto.getNome();
        this.login = usuarioEntradaDto.getLogin();
        this.senha = usuarioEntradaDto.getSenha();
    }

    //--Construtor para transforma (Dto - Entity) da classe UsuarioAtualizaDto.
    public UsuarioEntity(UsuarioAtualizaDto usuarioAtualizaDto) {
        this.cpf = usuarioAtualizaDto.getCpf();
        this.nome = usuarioAtualizaDto.getNome();
        this.login = usuarioAtualizaDto.getLogin();
    }


    public UsuarioEntity() {
    }

    public UsuarioEntity(Long id, String cpf, String nome, String login, String senha) {
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
