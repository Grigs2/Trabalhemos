package com.example.Trabalhemos.services;

import com.example.Trabalhemos.entities.Aplicacao;
import com.example.Trabalhemos.repositories.AplicacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AplicacaoService {

    @Autowired
    private AplicacaoRepository aplicacaoRepository;

    public Aplicacao Aplicar(Aplicacao aplicacao) {
        return aplicacaoRepository.save(aplicacao);
    }
}
