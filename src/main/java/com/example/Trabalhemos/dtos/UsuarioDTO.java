package com.example.Trabalhemos.dtos;

import com.example.Trabalhemos.entities.Usuario;

import java.io.Serial;
import java.io.Serializable;

public record UsuarioDTO(Long id,
                         String email,
                         String senha,
                         String tipo) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public static Usuario toEntity(UsuarioDTO usuarioDTO) {
        if (usuarioDTO == null) return null;
        return new Usuario(usuarioDTO.email(), usuarioDTO.senha(), usuarioDTO.tipo());
    }

    public static UsuarioDTO toDTO(Usuario usuario) {
        if (usuario == null) return null;
        return new UsuarioDTO(usuario.getId(), usuario.getEmail(), null , usuario.getTipo());
    }
}
