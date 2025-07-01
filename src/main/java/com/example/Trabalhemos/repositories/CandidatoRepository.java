package com.example.Trabalhemos.repositories;

import com.example.Trabalhemos.entities.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
}
