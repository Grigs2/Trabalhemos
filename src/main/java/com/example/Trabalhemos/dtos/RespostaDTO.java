package com.example.Trabalhemos.dtos;

import java.io.Serial;
import java.io.Serializable;

public record RespostaDTO(String pergunta, String resposta) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
} 