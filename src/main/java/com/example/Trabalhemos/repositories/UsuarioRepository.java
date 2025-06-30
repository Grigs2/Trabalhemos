package com.example.Trabalhemos.repositories;

import com.example.Trabalhemos.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


    @Query(value = "SELECT usu FROM Usuario usu " + "WHERE usu.email=:email AND usu.senha=:senha")
    Optional<Usuario> findByEmailAndSenha(String email, String  senha);

}
