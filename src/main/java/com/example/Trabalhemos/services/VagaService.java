package com.example.Trabalhemos.services;

import com.example.Trabalhemos.entities.Empresa;
import com.example.Trabalhemos.entities.Vaga;
import com.example.Trabalhemos.repositories.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VagaService {

    @Autowired
    private VagaRepository vagaRepository;

    public List<Vaga> findAll() {
        return vagaRepository.findAll();
    }

    public Vaga Salvar(Vaga vaga) {
        if (vaga == null) {return null;}
        return vagaRepository.save(vaga);
    }

    public List<Vaga> BuscarVagasEmAberto(String status) {
        if (status == null) {return null;}
        return vagaRepository.findByStatus(status);
    }

    public List<Vaga> BuscarVagasPorEmpresa(Empresa empresa) {
        if (empresa == null) {return null;}
        return vagaRepository.findByEmpresa(empresa);
    }


}
