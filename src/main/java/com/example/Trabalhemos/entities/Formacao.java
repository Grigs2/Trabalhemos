package com.example.Trabalhemos.entities;

import jakarta.persistence.*;
import lombok.Data;

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



}
