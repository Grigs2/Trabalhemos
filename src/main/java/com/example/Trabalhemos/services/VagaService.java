package com.example.Trabalhemos.services;

import com.example.Trabalhemos.entities.Empresa;
import com.example.Trabalhemos.entities.Vaga;
import com.example.Trabalhemos.exceptions.CondicaoInvalidaException;
import com.example.Trabalhemos.exceptions.DadoInvalidoException;
import com.example.Trabalhemos.repositories.EmpresaRepository;
import com.example.Trabalhemos.repositories.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.time.LocalDate;
import java.util.List;

@Service
public class VagaService {

    @Autowired
    private VagaRepository vagaRepository;
    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Vaga> findAll() {
        return vagaRepository.findAll();
    }

    public Vaga Salvar(Vaga vaga, Long idEmpresa) {
        if (vaga == null) {return null;}
        vaga.setEmpresa(empresaRepository.findById(idEmpresa).orElse(null));
        vaga.getPerguntas().forEach(p -> p.setVaga(vaga));
        return vagaRepository.save(vaga);
    }

    public List<Vaga> BuscarVagasEmAberto(String status) {
        if (status == null) {return null;}
        return vagaRepository.findByStatus(status);
    }

    public List<Vaga> BuscarVagasPorEmpresa(Long id) {
        if (id == null) {return null;}
        Empresa empresa = empresaRepository.findById(id).orElse(null);
        if (empresa == null) {return null;}
        if(empresa.getUsuario().getId() == null) {return null;}
        return vagaRepository.findByEmpresa(empresa);
    }

    public Vaga BuscarVagaPorId(Long id) {
        if (id == null) {return null;}
        return vagaRepository.findById(id).orElse(null);
    }

    public Vaga prorrogarDataEncerramento(Long idVaga, LocalDate novaData, Empresa empresa) {
        if (idVaga == null || novaData == null || empresa == null) {
            throw new DadoInvalidoException("Dados invalidos");}

        Vaga vaga = vagaRepository.findById(idVaga).orElse(null);
        if (vaga == null) {throw new DadoInvalidoException("Dados invalidos");}

        if(!vaga.getEmpresa().getId().equals(empresa.getId())) {throw new CondicaoInvalidaException("Voce não tem acesso a essa vaga");}
        if(vaga.getDataEncerramento().isBefore(LocalDate.now())) {throw new CondicaoInvalidaException("Vaga já encerrada");}
        if(vaga.getDataEncerramento().isAfter(novaData)) {throw new CondicaoInvalidaException("Nova data invalida");}
        vaga.setDataEncerramento(novaData);
        return vagaRepository.save(vaga);
    }
}
