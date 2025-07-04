package com.example.Trabalhemos.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
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
    public LocalDate dataNascimento;
    @Column(name = "telefone", nullable = false, length = 20)
    public String telefone;
    @Column(name = "criadoEm", nullable = false)
    public LocalDate criadoEm;
    @Column(name = "endereco", nullable = false, length = 100)
    public String endereco;
    @Column(name = "cidade", nullable = false, length = 50)
    public String cidade;
    @Column(name = "estado", nullable = false, length = 50)
    public String estado;
    @Column(name = "cep", nullable = false, length = 20)
    public String cep;

    @Lob
    @Column(name = "curriculo", nullable = true, columnDefinition = "BYTEA")
    public byte[] curriculo;

    @OneToMany(mappedBy = "candidato", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Formacao> formacoes;

    @OneToMany(mappedBy = "candidato", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Experiencia> experiencias;

    @OneToMany(mappedBy = "candidato", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Linguagem> linguagens;

    public Candidato(Usuario usuario, String nome, String cpf, LocalDate dataNascimento, String telefone, LocalDate criadoEm, String endereco,
                     String cidade, String estado, String cep, List<Formacao> formacoes, List<Experiencia> experiencias, List<Linguagem> linguagens) {

        this.usuario = usuario;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.criadoEm = criadoEm;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.formacoes = formacoes;
        this.experiencias = experiencias;
        this.linguagens = linguagens;
    }
public Candidato() {}
}
