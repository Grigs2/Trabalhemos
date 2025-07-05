package com.example.Trabalhemos.controllers;

import com.example.Trabalhemos.dtos.AplicacaoDTO;
import com.example.Trabalhemos.entities.Aplicacao;
import com.example.Trabalhemos.exceptions.CandidatoInvalidoException;
import com.example.Trabalhemos.services.AplicacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Aplicacao")
public class AplicacaoController {
    @Autowired
    private AplicacaoService aplicacaoService;

    @PostMapping("/Salvar/{id_vaga}/{id_candidato}")
    public ResponseEntity<AplicacaoDTO> Salvar(@RequestBody AplicacaoDTO aplicacaoDTO,
                                             @PathVariable Long id_vaga, 
                                             @PathVariable Long id_candidato) {
        Aplicacao aplicacaoSalva = aplicacaoService.Aplicar(
            AplicacaoDTO.toEntity(aplicacaoDTO), 
            id_vaga, 
            id_candidato
        );
        
        return ResponseEntity.ok().body(AplicacaoDTO.toDTO(aplicacaoSalva));
    }

    @PutMapping("/{id_aplicacao}/Respostas")
    public ResponseEntity<AplicacaoDTO> atualizarRespostas(@PathVariable Long id_aplicacao,
                                                          @RequestBody List<String> respostas) {
        Aplicacao aplicacaoAtualizada = aplicacaoService.atualizarRespostas(id_aplicacao, respostas);
        return ResponseEntity.ok().body(AplicacaoDTO.toDTO(aplicacaoAtualizada));
    }

    @ExceptionHandler(CandidatoInvalidoException.class)
    public ResponseEntity<String> handleCandidatoInvalido(CandidatoInvalidoException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
