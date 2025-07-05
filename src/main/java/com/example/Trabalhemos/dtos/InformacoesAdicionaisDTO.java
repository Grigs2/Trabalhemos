package com.example.Trabalhemos.dtos;

import com.example.Trabalhemos.entities.Aplicacao;
import com.example.Trabalhemos.entities.InformacoesAdicionais;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public record InformacoesAdicionaisDTO(Long id, PerguntasAdicionaisDTO pergunta, String Resposta) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1678L;

    public static InformacoesAdicionaisDTO toDTO(InformacoesAdicionais informacoesAdicionais) {
        if (informacoesAdicionais == null) return null;
        return new InformacoesAdicionaisDTO(informacoesAdicionais.getId(), PerguntasAdicionaisDTO.toDTO(informacoesAdicionais.getPergunta()), informacoesAdicionais.getResposta());
    }

    public static InformacoesAdicionais toEntity(InformacoesAdicionaisDTO dto) {
        if (dto == null) return null;
        return new InformacoesAdicionais(PerguntasAdicionaisDTO.toEntity(dto.pergunta()), dto.Resposta());
    }

    public static List<InformacoesAdicionais> ListToEntity(List<InformacoesAdicionaisDTO> dtos) {
        if (dtos == null) return null;
        List<InformacoesAdicionais> list = new ArrayList<>();
        dtos.forEach(dto -> list.add(toEntity(dto)));
        return list;
    }

    public static List<InformacoesAdicionaisDTO> ListToDTO(List<InformacoesAdicionais> list) {
        if (list == null) return null;
        List<InformacoesAdicionaisDTO> dtos = new ArrayList<>();
        list.forEach(dto -> dtos.add(toDTO(dto)));
        return dtos;
    }
}
