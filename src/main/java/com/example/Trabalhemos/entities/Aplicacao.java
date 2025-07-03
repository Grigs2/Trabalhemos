package com.example.Trabalhemos.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "aplicacao", schema = "public")
public class Aplicacao {

    @Id
    @SequenceGenerator(name="SEQ", sequenceName="public.seq_aplicacao", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ")
    public Long id;

    @ManyToOne
    @JoinColumn(name = "id_vaga", referencedColumnName = "id")
    public Vaga vaga;

    @ManyToOne
    @JoinColumn(name = "id_candidato", referencedColumnName = "id")
    public Candidato candidato;

    @Column(name = "status", nullable = false, length = 50)
    public String status;

    @OneToMany(mappedBy = "aplicacao", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<InformacoesAdicionais> informacoesAdicionais;

    public Aplicacao(Vaga vaga, Candidato candidato, String status, List<InformacoesAdicionais> informacoesAdicionais) {
        this.vaga = vaga;
        this.candidato = candidato;
        this.status = status;
        this.informacoesAdicionais = informacoesAdicionais;
    }
    public Aplicacao() {}
}
