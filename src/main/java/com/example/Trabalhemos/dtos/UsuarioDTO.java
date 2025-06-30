package com.example.Trabalhemos.dtos;

import java.io.Serial;
import java.io.Serializable;

public record UsuarioDTO(Long id,
                         String email,
                         String senha,
                         String tipo) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;



}
