package com.crud.usuario.login.controllers;

import com.crud.usuario.login.dtos.LoginDto;
import com.crud.usuario.login.dtos.LoginTrocaSenhaDto;
import com.crud.usuario.login.services.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final  LoginService loginService;
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }



    @PostMapping
    public ResponseEntity<String> logarUsuario(@RequestBody LoginDto loginDto){
        boolean retorno = loginService.logarUsuario(loginDto);
        if(retorno){
            return ResponseEntity.status(HttpStatus.OK).body("Login realizado com sucesso");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao logar");
        }

    }

    @PutMapping("/{login}")
    public ResponseEntity<String> atualizarSenha(@PathVariable String login, @RequestBody LoginTrocaSenhaDto trocaSenhaDto){
        boolean retorno = loginService.trocarSenha(login, trocaSenhaDto);
        if(retorno){
            return ResponseEntity.status(HttpStatus.OK).body("Senha atualizada com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao atualizar senha");
        }
    }
}
