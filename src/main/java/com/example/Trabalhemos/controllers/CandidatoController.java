package com.example.Trabalhemos.controllers;

import com.example.Trabalhemos.dtos.CandidatoDTO;
import com.example.Trabalhemos.dtos.CurriculoDTO;
import com.example.Trabalhemos.entities.Candidato;
import com.example.Trabalhemos.exceptions.CondicaoInvalidaException;
import com.example.Trabalhemos.exceptions.DadoInvalidoException;
import com.example.Trabalhemos.services.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    @GetMapping("/{id_usuario}")
    public ResponseEntity<CandidatoDTO> Buscar(@PathVariable Long id_usuario) {
        return ResponseEntity.ok().body(CandidatoDTO.toDTO(candidatoService.findByUsuarioId(id_usuario)));
    }

    @PutMapping("/{id}/Curriculo")
    public ResponseEntity<String> adicionarCurriculo(@PathVariable Long id, @RequestParam("arquivo") MultipartFile arquivo) {
        return ResponseEntity.ok().body(candidatoService.SalvarCurriculo(id, arquivo));
    }

    @GetMapping("/{id}/BaixarCurriculo")
    public ResponseEntity<byte[]> downloadCurriculo(@PathVariable Long id) {
        return candidatoService.BaixarCurriculo(id);
    }

    @GetMapping("/{id}/Curriculo")
    public ResponseEntity<CurriculoDTO> verificarCurriculo(@PathVariable Long id) {
        Candidato candidato = candidatoService.findById(id);
        if (candidato == null) {
            return ResponseEntity.notFound().build();
        }
        
        if (candidato.getCurriculo() == null) {
            return ResponseEntity.noContent().build();
        }
        
        return ResponseEntity.ok().body(CurriculoDTO.toDTO(candidato.getCurriculo()));
    }

    @ExceptionHandler(DadoInvalidoException.class)
    public ResponseEntity<String> DadoInvalidoException(DadoInvalidoException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
    @ExceptionHandler(CondicaoInvalidaException.class)
    public ResponseEntity<String> CondicaoInvalidaException(CondicaoInvalidaException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
