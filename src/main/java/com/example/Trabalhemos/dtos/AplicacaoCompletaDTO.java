package com.example.Trabalhemos.dtos;

import com.example.Trabalhemos.entities.Aplicacao;
import com.example.Trabalhemos.entities.Candidato;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public record AplicacaoCompletaDTO(Long id, String status, CandidatoDTO candidato, List<RespostaDTO> respostas) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public static AplicacaoCompletaDTO toDTO(Aplicacao aplicacao) {
        if (aplicacao == null) return null;
        
        List<RespostaDTO> respostas = new ArrayList<>();
        if (aplicacao.getInformacoesAdicionais() != null) {
            aplicacao.getInformacoesAdicionais().forEach(info -> {
                respostas.add(new RespostaDTO(
                    info.getPergunta().getPergunta(),
                    info.getResposta()
                ));
            });
        }
        
        return new AplicacaoCompletaDTO(
            aplicacao.getId(),
            aplicacao.getStatus(),
            CandidatoDTO.toDTO(aplicacao.getCandidato()),
            respostas
        );
    }

    public static List<AplicacaoCompletaDTO> ListToDTO(List<Aplicacao> aplicacoes) {
        if (aplicacoes == null) return null;
        List<AplicacaoCompletaDTO> dtos = new ArrayList<>();
        aplicacoes.forEach(aplicacao -> dtos.add(toDTO(aplicacao)));
        return dtos;
    }
} 