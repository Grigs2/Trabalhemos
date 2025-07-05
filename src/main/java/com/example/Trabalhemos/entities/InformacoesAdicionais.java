package com.example.Trabalhemos.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "informacoesAdicionais", schema = "public")
public class InformacoesAdicionais {

    @Id
    @SequenceGenerator(name="SEQ", sequenceName="public.seq_informacoesAdicionais", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ")
    public Long id;

    @ManyToOne
    @JoinColumn(name = "id_aplicacao", referencedColumnName = "id")
    public Aplicacao aplicacao;

    @OneToOne
    @JoinColumn(name = "id_pergunta", referencedColumnName = "id")
    public PerguntasAdicionais pergunta;

    @Column(name = "resposta", nullable = false, length = 1000)
    public String resposta;

    public InformacoesAdicionais() {}

    public InformacoesAdicionais(PerguntasAdicionais pergunta, String resposta) {
        this.pergunta = pergunta;
        this.resposta = resposta;
    }
}
