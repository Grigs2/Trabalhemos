package com.example.Trabalhemos.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "curriculo", schema = "public")
public class Curriculo {

    @Id
    @SequenceGenerator(name="SEQ_CURRICULO", sequenceName="public.seq_curriculo", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CURRICULO")
    private Long id;

    @Lob
    @Column(name = "curriculo", columnDefinition = "bytea", nullable = true)
    private byte[] curriculo;

    @OneToOne
    @JoinColumn(name = "id_candidato", referencedColumnName = "id")
    public Candidato candidato;
}
