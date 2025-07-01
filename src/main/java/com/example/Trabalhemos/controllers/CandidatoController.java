package com.example.Trabalhemos.controllers;

import com.example.Trabalhemos.dtos.CandidatoDTO;
import com.example.Trabalhemos.entities.Candidato;
import com.example.Trabalhemos.services.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Candidato")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    @PostMapping("/Salvar")
    public String salvar(@RequestBody CandidatoDTO dto) {
        if(dto==null){return "Não foi possivel salvar o Candidato. Erro 001.";}
        return candidatoService.SalvarCandidato(CandidatoDTO.toEntity(dto));
    }
}
