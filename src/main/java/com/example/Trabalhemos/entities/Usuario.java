package com.example.Trabalhemos.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "usuario", schema = "public")
@Data
public class Usuario implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="SEQ", sequenceName="public.seq_usuario", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ")
    public Long id;

    @Column(name = "email", nullable = false, length = 100)
    public String email;

    @Column(name= "senha", nullable = false, length = 100)
    public String senha;

    @Column(name= "tipo", nullable = false, length = 100)
    public String tipo;

    public Usuario(String email, String senha, String tipo) {
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
    }

}
