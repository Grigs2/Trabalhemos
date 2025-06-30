package com.example.Trabalhemos.repositories;

import com.example.Trabalhemos.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
