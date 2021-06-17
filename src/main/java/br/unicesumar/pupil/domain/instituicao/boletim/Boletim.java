package br.unicesumar.pupil.domain.instituicao.boletim;

import br.unicesumar.pupil.domain.instituicao.aluno.Aluno;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Boletim {
    
    @EqualsAndHashCode.Include
    @Id
    private String id = UUID.randomUUID().toString();

    @OneToOne
    private Aluno aluno;
    
    private Integer bimestre;

    public Boletim(Aluno aluno, Integer bimestre) {
        super();
        this.aluno = aluno;
        this.bimestre = bimestre;
    }
   
}
