package com.example.Trabalhemos.services;

import com.example.Trabalhemos.entities.Aplicacao;
import com.example.Trabalhemos.exceptions.CandidatoInvalidoException;
import com.example.Trabalhemos.repositories.AplicacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AplicacaoService {

    @Autowired
    private AplicacaoRepository aplicacaoRepository;

    public Aplicacao Aplicar(Aplicacao aplicacao) {
        if (aplicacao.getVaga().getTipo()!=null){
            if ((aplicacao.getVaga().getTipo().equalsIgnoreCase("estagio") ||
                    aplicacao.getVaga().getTipo().equalsIgnoreCase("trainee")) &&
                    aplicacao.getCandidato().getFormacoes().stream().noneMatch(formacao -> "cursando".equalsIgnoreCase(formacao.getStatus()))) {
                throw new CandidatoInvalidoException("Seu perfil não corresponde aos requisitos da vaga de estágio.");
            }
        }
        return aplicacaoRepository.save(aplicacao);
    }
}
