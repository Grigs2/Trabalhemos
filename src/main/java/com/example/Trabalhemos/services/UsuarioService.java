package com.example.Trabalhemos.services;

import com.example.Trabalhemos.entities.Usuario;
import com.example.Trabalhemos.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.OptionalInt;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario login(String email, String senha){
        return usuarioRepository.findByEmailAndSenha(email, senha).orElse(null);
    }

}
