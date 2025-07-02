package com.example.Trabalhemos.dtos;

import com.example.Trabalhemos.entities.Empresa;
import com.example.Trabalhemos.entities.Usuario;
import com.example.Trabalhemos.repositories.UsuarioRepository;

import java.io.Serial;
import java.io.Serializable;

public record EmpresaDTO(Long id,
                         String nome,
                         String razaoSocial,
                         String nomeFantasia,
                         String cnpj,
                         UsuarioDTO usuarioDTO) implements Serializable {

    @Serial
    private static final long serialVersionUID = 12323L;

    public static EmpresaDTO toEmpresaDTO(Empresa empresa) {
        if (empresa != null) return new EmpresaDTO(empresa.getId(), empresa.getNome(),
                                                    empresa.getRazaoSocial(), empresa.getNomeFantasia(),
                                                    empresa.getCnpj(), UsuarioDTO.toDTO(empresa.getUsuario()));
        else return null;
    }
    public static Empresa toEmpresa(EmpresaDTO dto) {
        if (dto != null) return new Empresa(dto.id(), dto.nome(), dto.razaoSocial(), dto.nomeFantasia(), dto.cnpj(), UsuarioDTO.toEntity(dto.usuarioDTO()));
        else return null;
    }
}
