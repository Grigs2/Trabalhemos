package com.example.Trabalhemos.entities;

import com.example.Trabalhemos.dtos.CandidatoDTO;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.action.internal.OrphanRemovalAction;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Candidato", schema = "public")
public class Candidato {

    @Id
    @SequenceGenerator(name="SEQ", sequenceName="public.seq_candidato", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    public Usuario usuario;

    @Column(name = "nome", nullable = false, length = 100)
    public String nome;
    @Column(name = "cpf", nullable = false, length = 50)
    public String cpf;
    @Column(name = "dataNascimento", nullable = false)
    public Date dataNascimento;
    @Column(name = "telefone", nullable = false, length = 20)
    public String telefone;
    @Column(name = "criadoEm", nullable = false)
    public Date criadoEm;
    @Column(name = "endereco", nullable = false, length = 100)
    public String endereco;
    @Column(name = "cidade", nullable = false, length = 50)
    public String cidade;
    @Column(name = "estado", nullable = false, length = 50)
    public String estado;
    @Column(name = "cep", nullable = false, length = 20)
    public String cep;

    @OneToMany(mappedBy = "candidato", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Formacao> formacoes;

    @OneToMany(mappedBy = "candidato", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Experiencia> experiencias;

    @OneToMany(mappedBy = "candidato", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Linguagem> linguagens;

    public Candidato(CandidatoDTO candidatoDTO) {
        this.usuario = candidatoDTO.usuario();
        this.nome = candidatoDTO.nome();
        this.cpf = candidatoDTO.cpf();
        this.dataNascimento = candidatoDTO.dataNascimento();
        this.telefone = candidatoDTO.telefone();
        this.criadoEm = Date.from(Instant.now());
        this.endereco = candidatoDTO.endereco();
        this.cidade = candidatoDTO.cidade();
        this.estado = candidatoDTO.estado();
        this.cep = candidatoDTO.cep();
        this.formacoes = candidatoDTO.formacoes();
        this.experiencias = candidatoDTO.experiencias();
        this.linguagens = candidatoDTO.liguagens();
    }

}
