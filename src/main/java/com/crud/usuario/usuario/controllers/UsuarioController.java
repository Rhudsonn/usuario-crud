package com.crud.usuario.usuario.controllers;

import com.crud.usuario.usuario.dtos.UsuarioAtualizaDto;
import com.crud.usuario.usuario.dtos.UsuarioEntradaDto;
import com.crud.usuario.usuario.dtos.UsuarioSaidaDto;
import com.crud.usuario.usuario.repositorys.UsuarioRepository;
import com.crud.usuario.usuario.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    //--Injeção de dependencia
    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService service) {
        this.usuarioService = service;
    }


    @PostMapping
    public ResponseEntity<String> cadastrarUsuario(@RequestBody UsuarioEntradaDto usuarioEntradaDto) {
        boolean retorno = usuarioService.cadastroUsuario(usuarioEntradaDto);
        if (retorno) {
            return ResponseEntity.status(HttpStatus.OK).body("Usuario cadastrado com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro Usuario ja existente com este Login"); //CONFLICT acontece quando o login ja é existente.
        }

    }

   @PutMapping
    public ResponseEntity<String> atualizarUsuario(@RequestBody UsuarioAtualizaDto usuarioAtualizaDto) {
        boolean retorno = usuarioService.atualizarUsuario(usuarioAtualizaDto);
        if (retorno) {
            return ResponseEntity.status(HttpStatus.OK).body("Usuario atualizado com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro Usuario ja existente com este Login");
        }

    }

    @GetMapping
    public ResponseEntity<List<UsuarioSaidaDto>> listarUsuarios(){
        List<UsuarioSaidaDto> lista = usuarioService.listarUsuarios();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<?> listarUsuariosPorCpf(@PathVariable String cpf){
        List<UsuarioSaidaDto> lista = usuarioService.listarUsuarioPorCpf(cpf);
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro usuario não encontrado com este cpf");
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(lista);
        }

    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<String> excluirUsuario(@PathVariable String cpf){
        boolean retorno = usuarioService.removerUsuario(cpf);
        if (retorno) {
            return ResponseEntity.status(HttpStatus.OK).body("Usuario removido com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario não encontrado com este cpf");
        }
    }




}
