package com.example.Trabalhemos.controllers;

import com.example.Trabalhemos.dtos.EmpresaDTO;
import com.example.Trabalhemos.entities.Empresa;
import com.example.Trabalhemos.repositories.EmpresaRepository;
import com.example.Trabalhemos.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.servlet.function.ServerResponse.ok;

@RestController
@RequestMapping("/Empresa")
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @PostMapping("/Cadastrar")
    public @ResponseBody ResponseEntity<EmpresaDTO> Cadastrar(@RequestBody EmpresaDTO empresaDTO) {
        Empresa empresa = empresaService.cadastrar(EmpresaDTO.toEmpresa(empresaDTO));
        return ResponseEntity.ok().body(EmpresaDTO.toEmpresaDTO(empresa));
    }
    @GetMapping("/{id_usuario}")
    public @ResponseBody ResponseEntity<EmpresaDTO> Buscar(@PathVariable Long id_usuario) {
        return ResponseEntity.ok().body(EmpresaDTO.toEmpresaDTO(empresaService.findByIdUsuario(id_usuario)));
    }



}
