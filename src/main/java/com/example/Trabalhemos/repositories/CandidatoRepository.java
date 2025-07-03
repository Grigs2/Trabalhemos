package com.example.Trabalhemos.repositories;

import com.example.Trabalhemos.entities.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
    Optional<Candidato> findByUsuarioId(Long idUsuario);
}
