package com.example.Trabalhemos.controllers;

import com.example.Trabalhemos.entities.Aplicacao;
import com.example.Trabalhemos.services.AplicacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Aplicacao")
public class AplicacaoController {
    @Autowired
    private AplicacaoService aplicacaoService;

    @PostMapping("/Salvar")
    public @ResponseBody ResponseEntity<Aplicacao> Salvar(@RequestBody Aplicacao aplicacao) {
        if (aplicacao == null) {return null;}
        if (aplicacao.getId() == null) {
            return ResponseEntity.ok().body(aplicacaoService.Aplicar(aplicacao));
        } return null;
    }
}
