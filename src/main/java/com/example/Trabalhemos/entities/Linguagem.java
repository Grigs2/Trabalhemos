package com.example.Trabalhemos.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "linguagem", schema = "public")
public class Linguagem {

    @Id
    @SequenceGenerator(name="SEQ", sequenceName="public.seq_linguagem", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_candidato", referencedColumnName = "id")
    public Candidato candidato;

    @Column(name = "nome", nullable = false, length = 50)
    public String nome;

    @Column(name = "nivel", nullable = false, length = 50)
    public String nivel;


    public Linguagem(Candidato candidato, String nome, String nivel) {
        this.candidato = candidato;
        this.nome = nome;
        this.nivel = nivel;
    }

    public Linguagem() {}

}
