package com.example.Trabalhemos.controllers;

import com.example.Trabalhemos.dtos.VagaDTO;
import com.example.Trabalhemos.entities.Empresa;
import com.example.Trabalhemos.exceptions.CondicaoInvalidaException;
import com.example.Trabalhemos.exceptions.DadoInvalidoException;
import com.example.Trabalhemos.services.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/Vaga")
public class VagaController {
    @Autowired
    private VagaService vagaService;

    @PostMapping("/Salvar/{idEmpresa}")
    public @ResponseBody ResponseEntity<VagaDTO> salvar(@RequestBody VagaDTO vagaDTO, @PathVariable Long idEmpresa) {
        if(vagaDTO==null)return null;
        return ResponseEntity.ok().body(VagaDTO.toDTO(vagaService.Salvar(VagaDTO.toEntity(vagaDTO), idEmpresa)));
    }

    @GetMapping("/PorEmpresa/{idEmpresa}")
    public @ResponseBody ResponseEntity<List<VagaDTO>> buscar(@PathVariable Long idEmpresa) {
        return ResponseEntity.ok().body(VagaDTO.listToDTO(vagaService.BuscarVagasPorEmpresa(idEmpresa)));
    }

    @GetMapping("/Todas")
    public @ResponseBody ResponseEntity<List<VagaDTO>> Todas() {
        return ResponseEntity.ok().body(VagaDTO.listToDTO(vagaService.findAll()));
    }

    @GetMapping("/PorStatus/{status}")
    public @ResponseBody ResponseEntity<List<VagaDTO>> emAberto(@PathVariable String status) {
        return ResponseEntity.ok().body(VagaDTO.listToDTO(vagaService.BuscarVagasEmAberto(status)));
    }

    @PutMapping("/Prorrogar/{idVaga}/{novaData}")
    public ResponseEntity<?> prorrogarDataEncerramento(
            @PathVariable Long idVaga,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate novaData,
            @RequestBody Empresa empresa) {

        vagaService.prorrogarDataEncerramento(idVaga, novaData, empresa);
        return ResponseEntity.ok("Data de encerramento prorrogada com sucesso.");
    }

    @ExceptionHandler(CondicaoInvalidaException.class)
    public ResponseEntity<String> CondicaoInvalidaException(CondicaoInvalidaException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(DadoInvalidoException.class)
    public ResponseEntity<String> DadoInvalidoException(DadoInvalidoException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
