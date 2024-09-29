package com.msvc.usuario.usuario_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msvc.usuario.usuario_service.entities.UsuarioEntity;

public interface UsuarioRepository extends  JpaRepository<UsuarioEntity, String> {

}
