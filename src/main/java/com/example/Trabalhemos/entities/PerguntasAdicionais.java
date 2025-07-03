package com.example.Trabalhemos.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "perguntasAdicionais", schema = "public")
public class PerguntasAdicionais {

    @Id
    @SequenceGenerator(name="SEQ", sequenceName="public.seq_perguntasAdicionais", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_vaga", referencedColumnName = "id")
    private Vaga vaga;

    @Column(name = "pergunta",nullable = false,length = 500)
    private String pergunta;

    public PerguntasAdicionais() {}

    public PerguntasAdicionais(Vaga vaga, String pergunta) {
        this.vaga = vaga;
        this.pergunta = pergunta;
    }
}
