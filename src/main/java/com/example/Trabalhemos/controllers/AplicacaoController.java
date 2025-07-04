package com.example.Trabalhemos.controllers;

import com.example.Trabalhemos.dtos.AplicacaoDTO;
import com.example.Trabalhemos.entities.Aplicacao;
import com.example.Trabalhemos.exceptions.CandidatoInvalidoException;
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
    public @ResponseBody ResponseEntity<AplicacaoDTO> Salvar(@RequestBody AplicacaoDTO aplicacaoDTO) {
        if (aplicacaoDTO == null) {return null;}
        if (aplicacaoDTO.id() == null) {
            return ResponseEntity.ok().body(AplicacaoDTO.toDTO(aplicacaoService.Aplicar(AplicacaoDTO.toEntity(aplicacaoDTO))));
        } return null;
    }

    @ExceptionHandler(CandidatoInvalidoException.class)
    public ResponseEntity<String> handleCandidatoInvalido(CandidatoInvalidoException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
