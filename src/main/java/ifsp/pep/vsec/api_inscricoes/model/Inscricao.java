package ifsp.pep.vsec.api_inscricoes.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(InscricaoId.class)
public class Inscricao {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_aluno", referencedColumnName = "id_aluno")
    private Aluno aluno;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_curso", referencedColumnName = "id_curso")
    private Curso curso;

    @Column(nullable = false)
    private LocalDateTime hrInscricao;
}