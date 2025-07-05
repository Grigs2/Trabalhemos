package com.example.Trabalhemos.services;

import com.example.Trabalhemos.entities.Candidato;
import com.example.Trabalhemos.exceptions.CondicaoInvalidaException;
import com.example.Trabalhemos.exceptions.DadoInvalidoException;
import com.example.Trabalhemos.repositories.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;

    public String SalvarCandidato(Candidato candidato) {
        candidatoRepository.save(candidato);
        return "Candidato salvo com sucesso!";
    }

    public List<Candidato> getCandidatos() {
        return candidatoRepository.findAll();
    }

    public String removerCandidato(Candidato candidato) {
        candidatoRepository.delete(candidato);
        return "Candidato removido com sucesso!";
    }
    public Candidato findByUsuarioId(Long id) {
        if(id == null) return null;
        return candidatoRepository.findByUsuarioId(id).orElse(null);
    }

//    public String SalvarCurriculo(Long id, MultipartFile arquivo) {
//        if(id == null || arquivo == null) throw new DadoInvalidoException("dados invalidos");
//        Candidato candidato = candidatoRepository.findById(id).orElse(null);
//        if(candidato == null) {throw new DadoInvalidoException("candidato nao encontrado");}
//
//        try {
//            candidato.setCurriculo(arquivo.getBytes());
//            candidatoRepository.save(candidato);
//        } catch (IOException e) {
//            throw new DadoInvalidoException("Arquivo nao encontrado");
//        }
//        return "Curriculo salvo com sucesso!";
//    }
//
//    public ResponseEntity<byte[]> BaixarCurriculo(Long id) {
//        Candidato candidato = candidatoRepository.findById(id)
//                .orElseThrow(() -> new CondicaoInvalidaException("Candidato não encontrado."));
//
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=curriculo.pdf")
//                .contentType(MediaType.APPLICATION_OCTET_STREAM)
//                .body(candidato.getCurriculo());
//    }
}
