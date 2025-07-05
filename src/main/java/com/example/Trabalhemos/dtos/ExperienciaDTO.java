package com.example.Trabalhemos.dtos;

import com.example.Trabalhemos.entities.Experiencia;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public record ExperienciaDTO(Long id, String papel, String organizacao, LocalDate inicio, LocalDate termino) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public static ExperienciaDTO toDTO(Experiencia e) {
        if (e == null) return null;
        return new ExperienciaDTO(e.getId(), e.getPapel(), e.getOrganizacao(), e.getInicio(), e.getTermino());
    }
    public static Experiencia toEntity(ExperienciaDTO ExperienciaDTO) {
        if (ExperienciaDTO == null) return null;
        return new Experiencia(ExperienciaDTO.papel(), ExperienciaDTO.organizacao(), ExperienciaDTO.inicio(), ExperienciaDTO.termino());
    }
    public static List<ExperienciaDTO> listToDTO(List<Experiencia> experiencias) {
        if (experiencias == null) return null;
        List<ExperienciaDTO> experienciasDTO = new ArrayList<>();
        experiencias.forEach(experiencia -> experienciasDTO.add(toDTO(experiencia)));
        return experienciasDTO;
    }
    public static List<Experiencia> listToEntity(List<ExperienciaDTO> dtos) {
        if (dtos == null) return null;
        List<Experiencia> experiencias = new ArrayList<>();
        dtos.forEach(ExperienciaDTO -> experiencias.add(toEntity(ExperienciaDTO)));
        return experiencias;
    }

}
