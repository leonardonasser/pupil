package br.unicesumar.pupil.domain.instituicao.nota;

import br.unicesumar.pupil.domain.instituicao.boletim.Boletim;
import br.unicesumar.pupil.domain.instituicao.usuario.Usuario;

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
public class Nota {

    @EqualsAndHashCode.Include
    @Id
    private String id = UUID.randomUUID().toString();

    private String nomeMateria;
    
    private Double nota;
    
    @OneToOne
    private Boletim boletim;
    
    @OneToOne
    private Usuario professor;

    public Nota(String nomeMateria, Double nota, Boletim boletim, Usuario professor) {
        super();
        this.nomeMateria = nomeMateria;
        this.nota = nota;
        this.boletim = boletim;
        this.professor = professor;
    }
    
}
