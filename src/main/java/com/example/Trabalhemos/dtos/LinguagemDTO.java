package com.example.Trabalhemos.dtos;

import com.example.Trabalhemos.entities.Candidato;
import com.example.Trabalhemos.entities.Linguagem;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public record LinguagemDTO(Long id, CandidatoDTO candidatoDTO, String nome, String nivel) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public static LinguagemDTO toDTO(Linguagem linguagem) {
        if (linguagem == null) return null;
        return new LinguagemDTO(linguagem.getId(), CandidatoDTO.toDTO(linguagem.getCandidato()), linguagem.getNome(), linguagem.getNivel());
    }
    public static Linguagem toEntity(LinguagemDTO linguagemDTO) {
        if (linguagemDTO == null) return null;
        return new Linguagem(linguagemDTO.id(), CandidatoDTO.toEntity(linguagemDTO.candidatoDTO()), linguagemDTO.nome(), linguagemDTO.nivel());
    }
    public static List<LinguagemDTO> listToDTO(List<Linguagem> linguagems) {
        if (linguagems == null) return null;
        List<LinguagemDTO> dtos = new ArrayList<>();
        linguagems.forEach(l -> dtos.add(toDTO(l)));
        return dtos;
    }
    public static List<Linguagem> listToEntity(List<LinguagemDTO> linguagemsDTO) {
        if (linguagemsDTO == null) return null;
        List<Linguagem> dtos = new ArrayList<>();
        linguagemsDTO.forEach(l -> dtos.add(toEntity(l)));
        return dtos;
    }
}
