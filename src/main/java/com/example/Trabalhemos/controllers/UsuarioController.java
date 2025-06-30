package com.example.Trabalhemos.controllers;

import com.example.Trabalhemos.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serial;
import java.io.Serializable;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{email}/{senha}")
    public @ResponseBody boolean autenticar(@PathVariable String email,
                                            @PathVariable String senha) {
//      Usuario usuario = autenticacaoService.autenticar(email, senha);
        return usuarioService.login(email, senha);
}

}
