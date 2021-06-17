package br.unicesumar.pupil.domain.instituicao.aluno;

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
public class Aluno {

    @EqualsAndHashCode.Include
    @Id
    private String id = UUID.randomUUID().toString();

    private String nome;
    
    @OneToOne
    private Usuario responsavel;
    
    private Date dataNascimento;

    public Aluno(String nome, Usuario responsavel, Date dataNascimento) {
        this.nome = nome;
        this.responsavel = responsavel;
        this.dataNascimento = dataNascimento;
    }    
    
}
