package ifsp.pep.vsec.api_inscricoes.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifsp.pep.vsec.api_inscricoes.model.Aluno;
import ifsp.pep.vsec.api_inscricoes.repository.AlunoRepository;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    public Aluno salvar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public List<Aluno> listar() {
        return alunoRepository.findAll();
    }

    public Aluno buscarPorId(Integer id){

        Optional<Aluno> optional = alunoRepository.findById(id);

        if(optional.isPresent())
        return optional.get();
        else 
            throw new RuntimeException("aluno nao encontrado");

    }

    public Aluno alterar(Integer id,Aluno aluno){

        Aluno alterado = alunoRepository.findById(id)
                            .orElseThrow(
                                () -> new RuntimeException("aluno nao encontrado")
                                
                            );

        aluno.setId_aluno(id);
        alterado = alunoRepository.save(aluno);
        return alterado;

    }

        public void excluir(Integer id) {
        Aluno alunoDelete = alunoRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Aluno não encontrado")
                );

        alunoRepository.delete(alunoDelete);
    }

}
