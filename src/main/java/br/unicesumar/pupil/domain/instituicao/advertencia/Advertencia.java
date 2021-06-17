package br.unicesumar.pupil.domain.instituicao.advertencia;

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
public class Advertencia {

    @EqualsAndHashCode.Include
    @Id
    private String id = UUID.randomUUID().toString();

    private String nome;
    
    private String descricao;
    
    private Date date;
    
    @OneToOne
    private Aluno aluno;
    
    @OneToOne
    private Usuario professor;

    public Advertencia(String nome, String descricao, Date date, Aluno aluno, Usuario professor) {
        super();
        this.nome = nome;
        this.descricao = descricao;
        this.date = date;
        this.aluno = aluno;
        this.professor = professor;
    }
    
}
