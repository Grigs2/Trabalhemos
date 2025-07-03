package com.example.Trabalhemos.repositories;

import com.example.Trabalhemos.entities.Aplicacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AplicacaoRepository extends JpaRepository<Aplicacao, Long> {
}
