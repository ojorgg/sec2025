package ifsp.pep.vsec.api_inscricoes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Curso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id_curso")
    private Integer id_curso;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false, length = 255)
    private String descricao;

    @Column(name = "ministrante", nullable = false)
    private String ministrante;

    @Column(name = "quantidade_maxima", nullable = false)
    private Integer quantidadeMaxima;
}
