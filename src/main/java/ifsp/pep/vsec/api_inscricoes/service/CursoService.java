package ifsp.pep.vsec.api_inscricoes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifsp.pep.vsec.api_inscricoes.model.Curso;
import ifsp.pep.vsec.api_inscricoes.repository.CursoRepository;

@Service
public class CursoService {
    
    @Autowired
    CursoRepository cursoRepository;

    public Curso salvar(Curso curso) {
//        Aluno alunoSalvo = new Aluno.builder()
//                .nome(dto.nome())
//                .prontuario(dto.prontuario())
//                .build();

        return cursoRepository.save(curso);
    }

    public List<Curso> listar() {
        return cursoRepository.findAll();
    }


    public Curso buscarPorId(Integer id) {
        Optional<Curso> optionalCliente =
                cursoRepository.findById(id);
        if (optionalCliente.isPresent())
            return optionalCliente.get();
        else
            throw new RuntimeException("Curso não encontrado");
    }

    public Curso alterar(Integer id, Curso curso) {
        Curso alterado = cursoRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Curso não encontrado")
                );

        curso.setId_curso(id);
        alterado = cursoRepository.save(curso);
        return alterado;
    }

    public void excluir(Integer id) {
        Curso alunoDelete = cursoRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Curso não encontrado")
                );

        cursoRepository.delete(alunoDelete);

//        alunoRepository.deleteById(id);
    }
}
