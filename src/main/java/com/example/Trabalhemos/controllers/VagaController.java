package com.example.Trabalhemos.controllers;

import com.example.Trabalhemos.dtos.VagaDTO;
import com.example.Trabalhemos.entities.Empresa;
import com.example.Trabalhemos.services.VagaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Vaga")
public class VagaController {
    @Autowired
    private VagaService vagaService;

    @PostMapping("/Salvar")
    public @ResponseBody ResponseEntity<VagaDTO> salvar(@RequestBody VagaDTO vagaDTO) {
        if(vagaDTO==null)return null;
        return ResponseEntity.ok().body(VagaDTO.toDTO(vagaService.Salvar(VagaDTO.toEntity(vagaDTO))));
    }

    @GetMapping("/PorEmpresa")
    public @ResponseBody ResponseEntity<List<VagaDTO>> buscar(@RequestBody Empresa empresa) {
        return ResponseEntity.ok().body(VagaDTO.listToDTO(vagaService.BuscarVagasPorEmpresa(empresa)));
    }

    @GetMapping("/Todas")
    public @ResponseBody ResponseEntity<List<VagaDTO>> Todas() {
        return ResponseEntity.ok().body(VagaDTO.listToDTO(vagaService.findAll()));
    }

    @GetMapping("/PorStatus/{status}")
    public @ResponseBody ResponseEntity<List<VagaDTO>> emAberto(@PathVariable String status) {
        return ResponseEntity.ok().body(VagaDTO.listToDTO(vagaService.BuscarVagasEmAberto(status)));
    }
}
