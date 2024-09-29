package com.msvc.usuario.usuario_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msvc.usuario.usuario_service.entities.UsuarioEntity;
import com.msvc.usuario.usuario_service.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public  ResponseEntity<UsuarioEntity> guardarUsuario(@RequestBody UsuarioEntity usuarioRequest){
        UsuarioEntity usuario = usuarioService.saveUsuario(usuarioRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<UsuarioEntity> obtenerUsuario (@PathVariable String usuarioId){

        UsuarioEntity usuario = usuarioService.getUsuario(usuarioId);
        return ResponseEntity.ok(usuario);
    }

    public ResponseEntity<List<UsuarioEntity>> listarUsuarios(){
        List<UsuarioEntity> usuarios = usuarioService.getAllUsuarios();
        return ResponseEntity.ok(usuarios);        
    }
}
