package com.crud.usuario.login.services;

import com.crud.usuario.login.dtos.LoginDto;
import com.crud.usuario.login.dtos.LoginTrocaSenhaDto;
import com.crud.usuario.usuario.entitys.UsuarioEntity;
import com.crud.usuario.usuario.repositorys.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    // Repositório responsável por acessar os dados do usuário
    private UsuarioRepository usuarioRepository;

    // Injeção de dependência via construtor
    public LoginService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    // =========================
// LOGIN DO USUÁRIO
// =========================
// Regras:
// - Buscar usuário pelo login informado
// - Se não existir → retorna false
// - Verificar se a senha informada corresponde à senha cadastrada
// - Se não corresponder → retorna false
// - Caso esteja correta → retorna true
    public boolean logarUsuario(LoginDto loginDto) {

        Optional<UsuarioEntity> verificaLogin = usuarioRepository.findByLogin(loginDto.getLogin());
        if (verificaLogin.isPresent()) {
            UsuarioEntity usuario = verificaLogin.get();
            if (usuario.getSenha().equals(loginDto.getSenha())) {
                return true;
            }
        }
        return false;
    }



    // =========================
// TROCAR SENHA
// =========================
// Regras:
// - Buscar usuário pelo login informado
// - Se não existir → retorna false
// - Verificar se a senha atual está correta
// - Verificar se a nova senha é igual à confirmação
// - Se alguma validação falhar → retorna false
// - Caso esteja tudo correto → atualizar a senha e salvar no banco
    public boolean trocarSenha(String login, LoginTrocaSenhaDto trocaSenhaDto) {

        Optional<UsuarioEntity> verificaLogin = usuarioRepository.findByLogin(login);

        if (verificaLogin.isPresent()) {
            UsuarioEntity usuario = verificaLogin.get();
            if (usuario.getSenha().equals(trocaSenhaDto.getSenhaAtual()) &&
            trocaSenhaDto.getSenhaNova().equals(trocaSenhaDto.getSenhaConfirmacao())){
                usuario.setSenha(trocaSenhaDto.getSenhaNova());
                usuarioRepository.save(usuario);
                return true;
            }
        }
        return false;
    }



}
