package ifsp.pep.vsec.api_inscricoes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InscricaoRequest {

    @JsonProperty("id_aluno")
    Integer idAluno;

    @JsonProperty("id_curso")
    Integer idCurso;
}
