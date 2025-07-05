package com.example.Trabalhemos.repositories;

import com.example.Trabalhemos.entities.Aplicacao;
import com.example.Trabalhemos.entities.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AplicacaoRepository extends JpaRepository<Aplicacao, Long> {
    List<Aplicacao> findByVaga(Vaga vaga);
}
