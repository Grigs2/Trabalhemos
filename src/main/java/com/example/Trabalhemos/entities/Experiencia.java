package com.example.Trabalhemos.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "experiencia", schema = "public")
public class Experiencia {

    @Id
    @SequenceGenerator(name="SEQ", sequenceName="public.seq_experiencia", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_candidato", referencedColumnName = "id")
    public Candidato candidato;

    @Column(name = "papel", nullable = false)
    private String papel;

    @Column(name = "organizacao", nullable = false)
    private String organizacao;

    @Column(name = "inicio",nullable = false)
    private LocalDate inicio;

    @Column(name = "termino", nullable = true)
    private LocalDate termino;

    public Experiencia(String papel, String organizacao,LocalDate inicio, LocalDate termino) {

        this.papel = papel;
        this.inicio = inicio;
        this.termino = termino;
        this.organizacao = organizacao;
    }
    public Experiencia() {}
}
