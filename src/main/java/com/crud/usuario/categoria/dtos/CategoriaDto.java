package com.crud.usuario.categoria.dtos;

import com.crud.usuario.categoria.entity.CategoriaEntity;

public class CategoriaDto {

    private Long id;
    private String nome;

    public CategoriaDto() {
    }

    public CategoriaDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    //--Construtor para transforma (Entity - Dto) da class CategoriaDto
    public CategoriaDto(CategoriaEntity categoriaEntity) {
        this.id = categoriaEntity.getId();
        this.nome = categoriaEntity.getNome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
