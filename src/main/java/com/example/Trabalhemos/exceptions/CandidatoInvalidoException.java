package com.example.Trabalhemos.exceptions;

public class CandidatoInvalidoException extends RuntimeException {
    public CandidatoInvalidoException(String mensagem) {
        super(mensagem);
    }
}