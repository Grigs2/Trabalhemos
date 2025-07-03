package com.example.Trabalhemos.services;

import com.example.Trabalhemos.entities.Empresa;
import com.example.Trabalhemos.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa cadastrar(Empresa empresa) {
        if(empresa!=null)return empresaRepository.save(empresa);
        return null;
    }

    public Empresa findByIdUsuario(Long idUsuario) {
        if(empresaRepository.findById(idUsuario).isPresent())return empresaRepository.findById(idUsuario).get();
        return null;
    }
    public void remover(Empresa empresa) {
        empresaRepository.delete(empresa);
    }

}
