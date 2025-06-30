package com.example.Trabalhemos.services;

import com.example.Trabalhemos.entities.Empresa;
import com.example.Trabalhemos.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa cadastrar(Empresa empresa) {
        if(empresa!=null)return empresaRepository.save(empresa);
        return null;
    }

    public void remover(Empresa empresa) {
        empresaRepository.delete(empresa);
    }

}
