package com.example.Trabalhemos.repositories;

import com.example.Trabalhemos.entities.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VagaRepository extends JpaRepository<Vaga, Long>  {


    List<Vaga> findByStatus(String status);

    List<Vaga> findByEmpresa(String empresa);




}
