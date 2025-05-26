package ifsp.pep.vsec.api_inscricoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifsp.pep.vsec.api_inscricoes.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso,Integer> {

}
