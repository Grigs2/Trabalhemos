package com.example.Trabalhemos.dtos;

import com.example.Trabalhemos.entities.Candidato;
import com.example.Trabalhemos.entities.Formacao;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public record FormacaoDTO(Long id, String titulo, String descricao, String status, LocalDate dataConclusao, CandidatoDTO candidatoDTO) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public static Formacao toEntity(FormacaoDTO formacaoDTO) {
        if (formacaoDTO == null) return null;
        return new Formacao(formacaoDTO.titulo(), formacaoDTO.descricao(), formacaoDTO.status(), formacaoDTO.dataConclusao(),
                CandidatoDTO.toEntity(formacaoDTO.candidatoDTO));
    }
    public static FormacaoDTO toDTO(Formacao formacao) {
        if (formacao == null) return null;
        return new FormacaoDTO(formacao.getId(), formacao.getInstituicao(), formacao.getCurso(), formacao.getStatus(), formacao.getDataConclusao(),
                CandidatoDTO.toDTO(formacao.getCandidato()));
    }
    public static List<FormacaoDTO> listToDTO(List<Formacao> formacoes) {
        if (formacoes == null) return null;
        List<FormacaoDTO> dtos = new ArrayList<>();
        formacoes.forEach(formacao -> dtos.add(toDTO(formacao)));
        return dtos;
    }
    public static List<Formacao> listToEntity(List<FormacaoDTO> formacoesDTO) {
        if (formacoesDTO == null) return null;
        List<Formacao> dtos = new ArrayList<>();
        formacoesDTO.forEach(formacao -> dtos.add(toEntity(formacao)));
        return dtos;
    }
}
