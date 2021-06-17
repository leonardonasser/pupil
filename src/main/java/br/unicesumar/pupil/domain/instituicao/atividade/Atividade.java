package br.unicesumar.pupil.domain.instituicao.atividade;

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
public class Atividade {

    @EqualsAndHashCode.Include
    @Id
    private String id = UUID.randomUUID().toString();
    
    private String nome;
    
    private String descricao;
    
    private Date dataInicio;
    
    private Date dataFim;
    
    private Double valoNota;

    @OneToOne
    private Aluno aluno;
    
    @OneToOne
    private Usuario professor;

    public Atividade(String nome, String descricao, Date dataInicio, Date dataFim, Double valoNota, Aluno aluno,
            Usuario professor) {
        super();
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valoNota = valoNota;
        this.aluno = aluno;
        this.professor = professor;
    }
    
}
