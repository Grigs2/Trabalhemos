package com.example.Trabalhemos.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "empresa", schema = "public")
public class Empresa {

    @Id
    @SequenceGenerator(name="SEQ", sequenceName="public.seq_empresa", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ")
    public Long id;

    @Column(name = "nome", nullable = false, length = 100)
    public String nome;

    @Column(name = "razaoSocial", nullable = false, length = 300)
    public String razaoSocial;

    @Column(name = "nomeFantasia", nullable = false, length = 300)
    public String nomeFantasia;

    @Column(name = "endereco", nullable = true, length = 100)
    public String endereco;
    @Column(name = "cidade", nullable = true, length = 50)
    public String cidade;
    @Column(name = "estado", nullable = true, length = 50)
    public String estado;

    @Column(name = "cnpj", nullable = false, length = 20)
    public String cnpj;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", nullable = false)
    private Usuario usuario;

    public Empresa(String nome, String razaoSocial, String nomeFantasia, String endereco,
                   String cidade, String estado, String cnpj, Usuario usuario) {
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.usuario = usuario;
    }
    public Empresa() {}
}
