package com.example.Trabalhemos.dtos;

import com.example.Trabalhemos.entities.PerguntasAdicionais;
import com.example.Trabalhemos.entities.Vaga;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public record VagaDTO(Long id, EmpresaDTO empresaDTO, String titulo, Date dataInicio, Date dataEncerramento, String status,
                      String informacoes, String tipo, String area, String salario, List<AplicacaoDTO> aplicacoesDTO, List<PerguntasAdicionaisDTO> PerguntasAdicionaisDTO)
        implements Serializable {
    @Serial
    private static final long serialVersionUID = 13789L;

    public static VagaDTO toDTO(Vaga vaga) {
        if (vaga == null) return null;
        return new VagaDTO(vaga.getId(), EmpresaDTO.toEmpresaDTO(vaga.getEmpresa()), vaga.getTitulo(), vaga.getDataInicio(),
                vaga.getDataEncerramento(), vaga.getStatus(), vaga.getInformacoes(), vaga.getTipo(), vaga.getArea(), vaga.getSalario(),
                AplicacaoDTO.ListToDTO(vaga.getAplicacaos()), com.example.Trabalhemos.dtos.PerguntasAdicionaisDTO.listToDTO(vaga.getPerguntas()));
    }

    public static Vaga toEntity(VagaDTO vagaDTO) {
        if (vagaDTO == null) return null;
        return new Vaga(EmpresaDTO.toEmpresa(vagaDTO.empresaDTO()), vagaDTO.titulo(), vagaDTO.dataInicio(), vagaDTO.dataEncerramento(),
                vagaDTO.status(), vagaDTO.informacoes(), vagaDTO.tipo(), vagaDTO.area(), vagaDTO.salario(), AplicacaoDTO.ListToEntity(vagaDTO.aplicacoesDTO()),
                com.example.Trabalhemos.dtos.PerguntasAdicionaisDTO.listToEntity(vagaDTO.PerguntasAdicionaisDTO()));
    }

    public static List<VagaDTO> listToDTO(List<Vaga> vagas) {
        if (vagas == null) return null;
        List<VagaDTO> vagasDTO = new ArrayList<>();
        vagas.forEach(vaga -> vagasDTO.add(toDTO(vaga)));
        return vagasDTO;
    }
}
