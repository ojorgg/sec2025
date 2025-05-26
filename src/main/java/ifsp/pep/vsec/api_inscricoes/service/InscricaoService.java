package ifsp.pep.vsec.api_inscricoes.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifsp.pep.vsec.api_inscricoes.dto.InscricaoRequest;
import ifsp.pep.vsec.api_inscricoes.model.Aluno;
import ifsp.pep.vsec.api_inscricoes.model.Curso;
import ifsp.pep.vsec.api_inscricoes.model.Inscricao;
import ifsp.pep.vsec.api_inscricoes.repository.AlunoRepository;
import ifsp.pep.vsec.api_inscricoes.repository.CursoRepository;
import ifsp.pep.vsec.api_inscricoes.repository.InscricaoRepository;

@Service
public class InscricaoService {
    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    CursoRepository cursoRepository;

    @Autowired
    InscricaoRepository inscricaoRepository;

    public Inscricao adicionar(InscricaoRequest inscricaoRequest) {
        Inscricao inscricao = new Inscricao();
        Aluno aluno = alunoRepository.findById(inscricaoRequest.getIdAluno())
                .orElseThrow(
                        () -> new RuntimeException("Aluno não encontrado")
                );


        Curso curso = cursoRepository.findById(inscricaoRequest.getIdCurso())
                .orElseThrow(
                    () -> new RuntimeException("Curso não encontrado")
                );
        inscricao.setAluno(aluno);
        inscricao.setCurso(curso);
        inscricao.setHrInscricao(LocalDateTime.now());
        return inscricaoRepository.save(inscricao);
    }

    public List<Inscricao> listar() {
        return inscricaoRepository.findAll();
    }

    public void excluir(InscricaoRequest inscricaoRequest) {
        Inscricao inscricao = new Inscricao();
        Aluno aluno = alunoRepository.findById(inscricaoRequest.getIdAluno())
                .orElseThrow(
                        () -> new RuntimeException("Aluno não encontrado")
                );


        Curso curso = cursoRepository.findById(inscricaoRequest.getIdCurso())
                .orElseThrow(
                        () -> new RuntimeException("Curso não encontrado")
                );
        inscricao.setAluno(aluno);
        inscricao.setCurso(curso);
        inscricaoRepository.delete(inscricao);
    }
}
