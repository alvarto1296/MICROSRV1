package com.msvc.usuario.usuario_service.services;

import java.util.List;

import com.msvc.usuario.usuario_service.entities.UsuarioEntity;

public interface UsuarioService {

    UsuarioEntity saveUsuario (UsuarioEntity usuario);

    List<UsuarioEntity> getAllUsuarios();

    UsuarioEntity getUsuario(String usuarioId);
}
