package ifsp.pep.vsec.api_inscricoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifsp.pep.vsec.api_inscricoes.model.Inscricao;
import ifsp.pep.vsec.api_inscricoes.model.InscricaoId;

@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao,InscricaoId> {

}
