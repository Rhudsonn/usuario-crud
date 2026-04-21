package com.crud.usuario.categoria.controllers;

import com.crud.usuario.categoria.dtos.CategoriaDto;
import com.crud.usuario.categoria.services.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<String> cadastraCategoria(@RequestBody CategoriaDto categoriaDto) {
        boolean retorno = categoriaService.cadastraCategoria(categoriaDto);
        if (retorno) {
            return ResponseEntity.status(HttpStatus.OK).body("Categoria cadastrada com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao cadastrar Categoria");
        }
    }


    @GetMapping
    public ResponseEntity<List<CategoriaDto>> listarCategorias() {
        List<CategoriaDto> resultado = categoriaService.listaCategoria();
        return ResponseEntity.ok(resultado);
    }
}
