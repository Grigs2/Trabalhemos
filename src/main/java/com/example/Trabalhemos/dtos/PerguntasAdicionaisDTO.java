package com.example.Trabalhemos.dtos;

import com.example.Trabalhemos.entities.PerguntasAdicionais;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public record PerguntasAdicionaisDTO(Long id, String pergunta) implements Serializable {
    @Serial
    private static final long serialVersionUID = 232321L;

    public static PerguntasAdicionaisDTO toDTO(PerguntasAdicionais perguntasAdicionais) {
        if (perguntasAdicionais == null) {return null;}
        return new PerguntasAdicionaisDTO(perguntasAdicionais.getId(),
                perguntasAdicionais.getPergunta());
    }

    public static PerguntasAdicionais toEntity(PerguntasAdicionaisDTO perguntasAdicionaisDTO) {
        if (perguntasAdicionaisDTO == null) {return null;}
        return new PerguntasAdicionais(perguntasAdicionaisDTO.pergunta());
    }

    public static List<PerguntasAdicionaisDTO> listToDTO(List<PerguntasAdicionais> list) {
        if (list == null) {return null;}
        List<PerguntasAdicionaisDTO> dtos = new ArrayList<>();
        list.forEach(perguntasAdicionais -> {dtos.add(toDTO(perguntasAdicionais));});
        return dtos;
    }

    public static List<PerguntasAdicionais> listToEntity(List<PerguntasAdicionaisDTO> list) {
        if (list == null) {return null;}
        List<PerguntasAdicionais> dtos = new ArrayList<>();
        list.forEach(PerguntasAdicionaisDTO -> {dtos.add(toEntity(PerguntasAdicionaisDTO));});
        return dtos;
    }


}
