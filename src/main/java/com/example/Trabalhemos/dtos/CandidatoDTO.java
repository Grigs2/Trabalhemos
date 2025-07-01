package com.example.Trabalhemos.dtos;

import com.example.Trabalhemos.entities.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public record CandidatoDTO(Long id,
                           Usuario usuario,
                           String nome,
                           String cpf,
                           Date dataNascimento,
                           String telefone,
                           Date criadoEm,
                           String endereco,
                           String cidade,
                           String estado,
                           String cep,
                           List<Formacao> formacoes,
                           List<Experiencia> experiencias,
                           List<Linguagem> liguagens) implements Serializable {

    @Serial
    private static final long serialVersionUID = -12312311L;

    public static CandidatoDTO toDTO(Candidato candidato) {
        if (candidato == null) {return null;}
        return new CandidatoDTO(candidato.getId(), candidato.getUsuario(), candidato.getNome(),candidato.getCpf(), candidato.getDataNascimento(),
                candidato.getTelefone(),candidato.getCriadoEm(),candidato.getEndereco(),candidato.getCidade(),candidato.getEstado(),
                candidato.getCep(),candidato.getFormacoes(),candidato.getExperiencias(),candidato.getLinguagens());
    }

    public static Candidato toEntity(CandidatoDTO candidatoDTO) {
        if (candidatoDTO == null) {return null;}
        return new Candidato(candidatoDTO);
    }

}
