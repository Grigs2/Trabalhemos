package com.example.Trabalhemos.dtos;

import com.example.Trabalhemos.entities.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public record CandidatoDTO(Long id,
                           UsuarioDTO usuarioDTO,
                           String nome,
                           String cpf,
                           Date dataNascimento,
                           String telefone,
                           Date criadoEm,
                           String endereco,
                           String cidade,
                           String estado,
                           String cep,
                           List<FormacaoDTO> formacoesDTO,
                           List<ExperienciaDTO> experienciasDTO,
                           List<LinguagemDTO> liguagensDTO) implements Serializable {

    @Serial
    private static final long serialVersionUID = -12312311L;

    public static CandidatoDTO toDTO(Candidato candidato) {
        if (candidato == null) {return null;}
        return new CandidatoDTO(candidato.getId(), UsuarioDTO.toDTO(candidato.getUsuario()), candidato.getNome(),candidato.getCpf(), candidato.getDataNascimento(),
                candidato.getTelefone(),candidato.getCriadoEm(),candidato.getEndereco(),candidato.getCidade(),candidato.getEstado(),
                candidato.getCep(), FormacaoDTO.listToDTO(candidato.getFormacoes()),ExperienciaDTO.listToDTO(candidato.getExperiencias()),
                LinguagemDTO.listToDTO(candidato.getLinguagens()));
    }

    public static Candidato toEntity(CandidatoDTO dto) {
        if (dto == null) {return null;}
        return new Candidato(dto.id(), UsuarioDTO.toEntity(dto.usuarioDTO), dto.nome(), dto.cpf(), dto.dataNascimento(), dto.telefone(),
                dto.criadoEm(), dto.endereco(), dto.cidade(), dto.estado(), dto.cep, FormacaoDTO.listToEntity(dto.formacoesDTO()),
                ExperienciaDTO.listToEntity(dto.experienciasDTO()), LinguagemDTO.listToEntity(dto.liguagensDTO()));
    }

}
