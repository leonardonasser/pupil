package br.unicesumar.pupil.domain.instituicao.mensagem;

import br.unicesumar.pupil.domain.gestao.instituicao.Instituicao;
import br.unicesumar.pupil.domain.instituicao.aluno.Aluno;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Mensagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private Aluno professor;

    private Integer responsavelId;
    
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm", timezone = "America/Sao_Paulo")
    private Date dataHora;
    
    @Enumerated(EnumType.STRING)
    private MensagemOrigem origem;
    
    private String texto;
    
    private boolean lidoProfessor;

    private boolean lidoResponsavel;

    public Mensagem(Aluno professor, Integer responsavelId, Date dataHora, MensagemOrigem origem, String texto,
            boolean lidoProfessor, boolean lidoResponsavel) {
        super();
        this.professor = professor;
        this.responsavelId = responsavelId;
        this.dataHora = dataHora;
        this.origem = origem;
        this.texto = texto;
        this.lidoProfessor = lidoProfessor;
        this.lidoResponsavel = lidoResponsavel;
    }
    
    
}
