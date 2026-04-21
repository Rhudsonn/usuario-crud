package com.crud.usuario.usuario.repositorys;

import com.crud.usuario.usuario.entitys.UsuarioEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    boolean existsByLogin(String login);

    Optional<UsuarioEntity> findByCpf(String cpf);
    Optional<UsuarioEntity> findByLogin(String login);

    Optional<UsuarioEntity> findBySenha(String senha);

}
