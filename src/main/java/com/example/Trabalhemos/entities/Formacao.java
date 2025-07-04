package com.example.Trabalhemos.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "formacao", schema = "public")
public class Formacao {

    @Id
    @SequenceGenerator(name="SEQ", sequenceName="public.seq_formacao", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ")
    private Long id;

    @Column(name = "instituicao", nullable = false)
    public String instituicao;

    @Column(name = "curso", nullable = false)
    public String curso;

    @Column(name = "status")
    public String status;

    @ManyToOne
    @JoinColumn(name = "id_candidato")
    public Candidato candidato;

    @Column(name = "dataConclusao", nullable = true)
    public LocalDate dataConclusao;

    public Formacao(String instituicao, String curso, String status, LocalDate dataConclusao,Candidato candidato) {
        this.instituicao = instituicao;
        this.curso = curso;
        this.status = status;
        this.candidato = candidato;
        this.dataConclusao = dataConclusao;
    }
    public Formacao() {}
}
