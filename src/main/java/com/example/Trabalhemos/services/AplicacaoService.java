package com.example.Trabalhemos.services;

import com.example.Trabalhemos.entities.Aplicacao;
import com.example.Trabalhemos.entities.PerguntasAdicionais;
import com.example.Trabalhemos.entities.Vaga;
import com.example.Trabalhemos.entities.Candidato;
import com.example.Trabalhemos.entities.InformacoesAdicionais;
import com.example.Trabalhemos.exceptions.CandidatoInvalidoException;
import com.example.Trabalhemos.repositories.AplicacaoRepository;
import com.example.Trabalhemos.repositories.CandidatoRepository;
import com.example.Trabalhemos.repositories.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AplicacaoService {

    @Autowired
    private AplicacaoRepository aplicacaoRepository;
    @Autowired
    private VagaRepository vagaRepository;
    @Autowired
    private CandidatoRepository candidatoRepository;

    public Aplicacao Aplicar(Aplicacao aplicacao, Long idVaga, Long idCandidato) {
    
        if (aplicacao == null) throw new IllegalArgumentException("Aplicação não pode ser nula");
        if (idVaga == null || idCandidato == null) throw new IllegalArgumentException("ID da vaga e ID do candidato são obrigatórios");
        if (aplicacao.getId() != null) throw new IllegalArgumentException("Não é possível criar uma aplicação com ID predefinido");

        Vaga vaga = vagaRepository.findById(idVaga).orElse(null);
        if (vaga == null) throw new IllegalArgumentException("Vaga não encontrada");

        Candidato candidato = candidatoRepository.findById(idCandidato).orElse(null);
        if (candidato == null) throw new IllegalArgumentException("Candidato não encontrado");

        aplicacao.setVaga(vaga);
        aplicacao.setCandidato(candidato);

        List<InformacoesAdicionais> informacoesAdicionais = new ArrayList<>();
        if (vaga.getPerguntas() != null && !vaga.getPerguntas().isEmpty()) {
            for (PerguntasAdicionais pergunta : vaga.getPerguntas()) {
                InformacoesAdicionais info = new InformacoesAdicionais();
                info.setPergunta(pergunta);
                info.setAplicacao(aplicacao);
                info.setResposta("");
                informacoesAdicionais.add(info);
            }
        }
        
        aplicacao.setInformacoesAdicionais(informacoesAdicionais);

        if (vaga.getTipo() != null && candidato.getFormacoes() != null) {
            if ((vaga.getTipo().equalsIgnoreCase("estagio") &&
                    candidato.getFormacoes().stream()
                            .noneMatch(formacao -> "cursando".equalsIgnoreCase(formacao.getStatus())))
                    || (vaga.getTipo().equalsIgnoreCase("trainee") &&
                    candidato.getFormacoes().stream()
                            .noneMatch(formacao -> "finalizado".equalsIgnoreCase(formacao.getStatus())))) {

                throw new CandidatoInvalidoException("Seu perfil não corresponde aos requisitos da vaga.");
            }
        }

        return aplicacaoRepository.save(aplicacao);
    }

    public Aplicacao atualizarRespostas(Long idAplicacao, List<String> respostas) {
        Aplicacao aplicacao = aplicacaoRepository.findById(idAplicacao).orElse(null);
        if (aplicacao == null) throw new IllegalArgumentException("Aplicação não encontrada");

        if (aplicacao.getInformacoesAdicionais() != null && respostas != null) {
            int minSize = Math.min(aplicacao.getInformacoesAdicionais().size(), respostas.size());
            for (int i = 0; i < minSize; i++) {
                aplicacao.getInformacoesAdicionais().get(i).setResposta(respostas.get(i));
            }
        }

        return aplicacaoRepository.save(aplicacao);
    }

    public List<Aplicacao> buscarAplicacoesPorVaga(Long idVaga) {
        if (idVaga == null) throw new IllegalArgumentException("ID da vaga é obrigatório");
        
        Vaga vaga = vagaRepository.findById(idVaga).orElse(null);
        if (vaga == null) throw new IllegalArgumentException("Vaga não encontrada");
        
        return aplicacaoRepository.findByVaga(vaga);
    }
}
