package com.crud.usuario.usuario.services;

import com.crud.usuario.usuario.dtos.UsuarioAtualizaDto;
import com.crud.usuario.usuario.dtos.UsuarioEntradaDto;
import com.crud.usuario.usuario.dtos.UsuarioSaidaDto;
import com.crud.usuario.usuario.entitys.UsuarioEntity;
import com.crud.usuario.usuario.repositorys.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    //--Injeção de dependência do repositório
    private final UsuarioRepository usuarioRepository;

    //--Construtor para inicializar o repositório
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;

    }


    // =========================
    // CADASTRAR USUÁRIO
    // =========================
    // Regra:
    // - Verifica se já existe um login igual
    // - Se existir → retorna false
    // - Se não → salva o usuário
    public boolean cadastroUsuario(UsuarioEntradaDto usuarioEntradaDto) {
        if (usuarioRepository.existsByLogin(usuarioEntradaDto.getLogin())) {
                return false;
            }
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioEntradaDto);
        usuarioRepository.save(usuarioEntity);
        return true;
    }


    // =========================
    // ATUALIZAR USUÁRIO
    // =========================
    // Regras:
    // - Buscar usuário pelo CPF
    // - Se não existir → retorna false
    // - Verificar se o novo login já existe
    // - Se existir → retorna false
    // - Caso contrário → atualiza os dados
    public boolean atualizarUsuario(UsuarioAtualizaDto usuarioAtualizaDto) {
        Optional<UsuarioEntity> verificaCpf = usuarioRepository.findByCpf(usuarioAtualizaDto.getCpf());
        Optional<UsuarioEntity> verificaLogin = usuarioRepository.findByLogin(usuarioAtualizaDto.getLogin());

        if (verificaCpf.isEmpty()){
            return false;
        }

        // Pega o usuário encontrado
        UsuarioEntity usuario = verificaCpf.get();

        // Se existe um usuário com esse login
        //  E esse usuário NÃO é o mesmo, (CPF diferente)
        // então o login já pertence a outra pessoa, entao vai da erro
        if (verificaLogin.isPresent() && !verificaLogin.get().getCpf().equals(usuarioAtualizaDto.getCpf())) {
            return false;
        }

        usuario.setNome(usuarioAtualizaDto.getNome());
        usuario.setLogin(usuarioAtualizaDto.getLogin());
        usuarioRepository.save(usuario);

        return true;
    }


    // =========================
    // LISTAR TODOS USUÁRIOS
    // =========================
    // Converte Entity → DTO de saída
    public List<UsuarioSaidaDto> listarUsuarios() {
        List<UsuarioSaidaDto> lista = new ArrayList<>();
        for (UsuarioEntity usuarioEntity : usuarioRepository.findAll()) {
            UsuarioSaidaDto saidaDto = new UsuarioSaidaDto(usuarioEntity);
            lista.add(saidaDto);
        }
        return lista;
    }



    // =========================
    // BUSCAR USUÁRIO POR CPF
    // =========================
    // Retorna lista (mesmo sendo um único usuário)
    public List<UsuarioSaidaDto> listarUsuarioPorCpf(String cpf) {
            Optional<UsuarioEntity> usuario = usuarioRepository.findByCpf(cpf);

            List<UsuarioSaidaDto> lista = new ArrayList<>();

           if(usuario.isPresent()){
               lista.add(new UsuarioSaidaDto(usuario.get()));
           }
           return lista;
        }


    // =========================
    // REMOVER USUÁRIO
    // =========================
    // - Busca por CPF
    // - Se existir → remove
    // - Se não → retorna false
        public boolean removerUsuario(String cpf){
        Optional<UsuarioEntity> usuario = usuarioRepository.findByCpf(cpf);
        if (usuario.isPresent()){
            usuarioRepository.delete(usuario.get());
            return true;
        }
        return false;
        }





}
