package com.example.Trabalhemos.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "curriculo", schema = "public")
public class Curriculo {

    @Id
    @SequenceGenerator(name="SEQ", sequenceName="public.seq_candidato", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ")
    private Long id;

    @Lob
    @Column(name = "curriculo", columnDefinition = "bytea", nullable = true)
    private byte[] curriculo;

    @OneToOne
    @JoinColumn(name = "id_candidato", referencedColumnName = "id")
    public Candidato candidato;
}
