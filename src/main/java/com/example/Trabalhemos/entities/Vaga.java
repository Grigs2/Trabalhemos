package com.example.Trabalhemos.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.Length;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "vaga", schema = "public")
public class Vaga {

    @Id
    @SequenceGenerator(name="SEQ", sequenceName="public.seq_vaga", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ")
    public Long id;

    @ManyToOne
    @JoinColumn(name = "id_empresa", referencedColumnName = "id")
    private Empresa empresa;

    @Column(name = "titulo", nullable = false, length = 100)
    public String titulo;

    @Column(name = "dataInicio", nullable = false)
    public LocalDate dataInicio;

    @Column(name = "dataEncerramento", nullable = false)
    public LocalDate dataEncerramento;

    @Column(name = "status", nullable = false, length = 50)
    public String status;

    @Column(name = "informacoes", nullable = false, length = 1000)
    public String informacoes;

    @Column(name = "tipo", nullable = false, length = 50)
    public String tipo;

    @Column(name = "area", nullable = false, length = 50)
    public String area;

    @Column(name = "salario", nullable = false, length = 50)
    public String salario;

    @OneToMany(mappedBy = "vaga", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Aplicacao> aplicacaos;

    @OneToMany(mappedBy = "vaga", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<PerguntasAdicionais> perguntas;

    public Vaga() {}

    public Vaga(Empresa empresa, String titulo, LocalDate dataInicio, LocalDate dataEncerramento, String status,
                String informacoes, String tipo,String area,  String salario,
                List<Aplicacao> aplicacaos, List<PerguntasAdicionais> perguntas) {
        this.empresa = empresa;
        this.titulo = titulo;
        this.area = area;
        this.dataInicio = dataInicio;
        this.dataEncerramento = dataEncerramento;
        this.status = status;
        this.informacoes = informacoes;
        this.tipo = tipo;
        this.salario = salario;
        this.aplicacaos = aplicacaos;
        this.perguntas = perguntas;
    }

}
