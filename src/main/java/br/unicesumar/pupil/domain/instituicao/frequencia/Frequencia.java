package br.unicesumar.pupil.domain.instituicao.frequencia;

import br.unicesumar.pupil.domain.instituicao.aluno.Aluno;
import br.unicesumar.pupil.domain.instituicao.usuario.Usuario;

import java.util.Date;
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
public class Frequencia {

    @EqualsAndHashCode.Include
    @Id
    private String id = UUID.randomUUID().toString();
    
    private boolean presente;
    
    @OneToOne
    private Aluno aluno;
    
    private Date dataHoraAula;
    
    @OneToOne
    private Usuario professor;

    public Frequencia(boolean presente, Aluno aluno, Date dataHoraAula, Usuario professor) {
        this.presente = presente;
        this.aluno = aluno;
        this.dataHoraAula = dataHoraAula;
        this.professor = professor;
    }   
    
}
