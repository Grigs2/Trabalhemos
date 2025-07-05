package com.example.Trabalhemos.dtos;

import com.example.Trabalhemos.entities.PerguntasAdicionais;
import com.example.Trabalhemos.entities.Vaga;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public record VagaDTO(Long id, String titulo, LocalDate dataInicio, LocalDate dataEncerramento, String status,
                      String informacoes, String tipo, String area, String salario,List<PerguntasAdicionaisDTO> PerguntasAdicionaisDTO)
        implements Serializable {
    @Serial
    private static final long serialVersionUID = 13789L;

    public static VagaDTO toDTO(Vaga vaga) {
        if (vaga == null) return null;
        return new VagaDTO(vaga.getId(), vaga.getTitulo(), vaga.getDataInicio(),
                vaga.getDataEncerramento(), vaga.getStatus(), vaga.getInformacoes(), vaga.getTipo(), vaga.getArea(), vaga.getSalario(),
                 com.example.Trabalhemos.dtos.PerguntasAdicionaisDTO.listToDTO(vaga.getPerguntas()));
    }

    public static Vaga toEntity(VagaDTO vagaDTO) {
        if (vagaDTO == null) return null;
        return new Vaga(vagaDTO.titulo(), vagaDTO.dataInicio(), vagaDTO.dataEncerramento(),
                vagaDTO.status(), vagaDTO.informacoes(), vagaDTO.tipo(), vagaDTO.area(), vagaDTO.salario(),
                com.example.Trabalhemos.dtos.PerguntasAdicionaisDTO.listToEntity(vagaDTO.PerguntasAdicionaisDTO()));
    }

    public static List<VagaDTO> listToDTO(List<Vaga> vagas) {
        if (vagas == null) return null;
        List<VagaDTO> vagasDTO = new ArrayList<>();
        vagas.forEach(vaga -> vagasDTO.add(toDTO(vaga)));
        return vagasDTO;
    }
}
