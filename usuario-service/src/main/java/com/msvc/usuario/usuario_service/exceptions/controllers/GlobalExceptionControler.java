package com.msvc.usuario.usuario_service.exceptions.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.msvc.usuario.usuario_service.exceptions.ResourceNotFoundException;
import com.msvc.usuario.usuario_service.response.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionControler {

    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException resourceNotFoundException){
        String mensaje = resourceNotFoundException.getMessage();

        ApiResponse response = new ApiResponse().builder()
                .message(mensaje)
                .succes(true)
                .status(HttpStatus.NOT_FOUND)
                .build();

        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
