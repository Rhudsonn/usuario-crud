package com.crud.usuario.categoria.services;

import com.crud.usuario.categoria.dtos.CategoriaDto;
import com.crud.usuario.categoria.entity.CategoriaEntity;
import com.crud.usuario.categoria.repositorys.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    // =========================
    // CADASTRAR CATEGORIA
    // =========================
    // Regras:
    // - Receber dados da categoria via DTO
    // - Converter DTO para Entity
    // - Salvar no banco usando o repository
    // - Retornar true após salvar
    public boolean cadastraCategoria(CategoriaDto categoriaDto){
        CategoriaEntity categoriaEntity = new CategoriaEntity(categoriaDto);

        categoriaRepository.save(categoriaEntity);
        return true;
    }


    // =========================
    // LISTAR CATEGORIAS
    // =========================
    // Regras:
    // - Buscar todas as categorias no banco
    // - Converter cada Entity para DTO
    // - Adicionar na lista de retorno
    // - Retornar lista de categorias
    public List<CategoriaDto> listaCategoria(){
        List<CategoriaDto> lista = new ArrayList<>();
        for (CategoriaEntity categoriaEntity : categoriaRepository.findAll()) {
            CategoriaDto dto = new CategoriaDto(categoriaEntity);
            lista.add(dto);
        }
        return lista;
    }

}
