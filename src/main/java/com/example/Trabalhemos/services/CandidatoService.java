package com.example.Trabalhemos.services;

import com.example.Trabalhemos.entities.Candidato;
import com.example.Trabalhemos.repositories.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;

    public String SalvarCandidato(Candidato candidato) {
        candidatoRepository.save(candidato);
        return "Candidato salvo com sucesso!";
    }

    public List<Candidato> getCandidatos() {
        return candidatoRepository.findAll();
    }

    public String removerCandidato(Candidato candidato) {
        candidatoRepository.delete(candidato);
        return "Candidato removido com sucesso!";
    }

}
