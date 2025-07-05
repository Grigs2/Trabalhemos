package com.example.Trabalhemos.services;

import com.example.Trabalhemos.entities.Candidato;
import com.example.Trabalhemos.entities.Curriculo;
import com.example.Trabalhemos.exceptions.CondicaoInvalidaException;
import com.example.Trabalhemos.exceptions.DadoInvalidoException;
import com.example.Trabalhemos.repositories.CandidatoRepository;
import com.example.Trabalhemos.repositories.CurriculoRepository;
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
    
    @Autowired
    private CurriculoRepository curriculoRepository;

    public String SalvarCandidato(Candidato candidato) {
        if (candidato == null) {return "erro ao cadastrar candidato";}
        candidato.getFormacoes().forEach(formacao -> {formacao.setCandidato(candidato);});
        candidato.getExperiencias().forEach(experiencia -> {experiencia.setCandidato(candidato);});
        candidato.getLinguagens().forEach(linguagem -> {linguagem.setCandidato(candidato);});
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

    public Candidato findById(Long id) {
        if(id == null) return null;
        return candidatoRepository.findById(id).orElse(null);
    }

    public String SalvarCurriculo(Long id, MultipartFile arquivo) {
        if(id == null || arquivo == null) throw new DadoInvalidoException("dados invalidos");
        Candidato candidato = candidatoRepository.findById(id).orElse(null);
        if(candidato == null) {throw new DadoInvalidoException("candidato nao encontrado");}

        try {
            // Verifica se já existe um currículo para o candidato
            Curriculo curriculo = candidato.getCurriculo();
            if (curriculo == null) {
                // Cria um novo currículo
                curriculo = new Curriculo();
                curriculo.setCandidato(candidato);
            }
            
            curriculo.setCurriculo(arquivo.getBytes());
            curriculoRepository.save(curriculo);
            
            // Atualiza a referência no candidato
            candidato.setCurriculo(curriculo);
            candidatoRepository.save(candidato);
            
        } catch (IOException e) {
            throw new DadoInvalidoException("Arquivo nao encontrado");
        }
        return "Curriculo salvo com sucesso!";
    }

    public ResponseEntity<byte[]> BaixarCurriculo(Long id) {
        Candidato candidato = candidatoRepository.findById(id)
                .orElseThrow(() -> new CondicaoInvalidaException("Candidato não encontrado."));

        if (candidato.getCurriculo() == null || candidato.getCurriculo().getCurriculo() == null) {
            throw new CondicaoInvalidaException("Currículo não encontrado para este candidato.");
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=curriculo.pdf")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(candidato.getCurriculo().getCurriculo());
    }
}
