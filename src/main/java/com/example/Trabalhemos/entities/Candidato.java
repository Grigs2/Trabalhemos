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

    public Candidato(Long id, Usuario usuario, String nome, String cpf, Date dataNascimento, String telefone, Date criadoEm, String endereco,
                     String cidade, String estado, String cep, List<Formacao> formacoes, List<Experiencia> experiencias, List<Linguagem> linguagens) {
        this.id = id;
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

}
