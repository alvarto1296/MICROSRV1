package com.msvc.usuario.usuario_service.services.Impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msvc.usuario.usuario_service.entities.UsuarioEntity;
import com.msvc.usuario.usuario_service.exceptions.ResourceNotFoundException;
import com.msvc.usuario.usuario_service.repositories.UsuarioRepository;
import com.msvc.usuario.usuario_service.services.UsuarioService;

@Service
public class UsuarioImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioEntity saveUsuario(UsuarioEntity usuario) {
        String randomUsuarioId = UUID.randomUUID().toString();
        usuario.setUsuarioId(randomUsuarioId);
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<UsuarioEntity> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public UsuarioEntity getUsuario(String usuarioId) {
        return usuarioRepository.findById(usuarioId).orElseThrow(() -> new ResourceNotFoundException("usuario no encontrado con el id "+ usuarioId));
    }
}
