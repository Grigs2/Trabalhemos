package com.example.Trabalhemos.dtos;

import com.example.Trabalhemos.entities.Curriculo;

import java.io.Serial;
import java.io.Serializable;

public record CurriculoDTO(Long id, Long idCandidato, byte[] curriculo) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public static CurriculoDTO toDTO(Curriculo curriculo) {
        if (curriculo == null) return null;
        return new CurriculoDTO(
            curriculo.getId(),
            curriculo.getCandidato() != null ? curriculo.getCandidato().getId() : null,
            curriculo.getCurriculo()
        );
    }

    public static Curriculo toEntity(CurriculoDTO dto) {
        if (dto == null) return null;
        Curriculo curriculo = new Curriculo();
        curriculo.setId(dto.id());
        curriculo.setCurriculo(dto.curriculo());
        return curriculo;
    }
} 