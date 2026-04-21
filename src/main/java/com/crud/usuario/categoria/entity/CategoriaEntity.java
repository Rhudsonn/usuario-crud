package com.crud.usuario.categoria.entity;

import com.crud.usuario.categoria.dtos.CategoriaDto;
import jakarta.persistence.*;

@Entity
@Table(name = "CATEGORIA")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    public CategoriaEntity() {
    }

    public CategoriaEntity(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    //--Construtor para transforma (Dto - Entity) da classe CategoriaDto.
    public CategoriaEntity(CategoriaDto categoriaDto) {
        this.id = categoriaDto.getId();
        this.nome = categoriaDto.getNome();
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
