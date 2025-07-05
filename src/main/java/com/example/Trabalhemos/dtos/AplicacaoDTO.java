package com.example.Trabalhemos.dtos;

import com.example.Trabalhemos.entities.Aplicacao;
import com.example.Trabalhemos.entities.InformacoesAdicionais;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public record AplicacaoDTO(Long id, String status, List<InformacoesAdicionaisDTO> informacoesAdicionaisDTO) implements Serializable {

    @Serial
    private static final long serialVersionUID = -1L;

    public static AplicacaoDTO toDTO(Aplicacao aplicacao) {
        if (aplicacao == null) return null;
        return new AplicacaoDTO(aplicacao.getId(), aplicacao.getStatus(), InformacoesAdicionaisDTO.ListToDTO(aplicacao.getInformacoesAdicionais()));
    }
    
    public static Aplicacao toEntity(AplicacaoDTO aplicacaoDTO) {
        if (aplicacaoDTO == null) return null;
        return new Aplicacao(aplicacaoDTO.status(), null);
    }
    
    public static List<AplicacaoDTO> ListToDTO(List<Aplicacao> aplicacoes) {
        if (aplicacoes == null) return null;
        ArrayList<AplicacaoDTO> aplicacaoDTOS = new ArrayList<>();
        aplicacoes.forEach(aplicacao -> aplicacaoDTOS.add(toDTO(aplicacao)));
        return aplicacaoDTOS;
    }
    
    public static List<Aplicacao> ListToEntity(List<AplicacaoDTO> aplicacoes) {
        if (aplicacoes == null) return null;
        ArrayList<Aplicacao> aplicacaoDTOS = new ArrayList<>();
        aplicacoes.forEach(aplicacao -> aplicacaoDTOS.add(toEntity(aplicacao)));
        return aplicacaoDTOS;
    }
}
