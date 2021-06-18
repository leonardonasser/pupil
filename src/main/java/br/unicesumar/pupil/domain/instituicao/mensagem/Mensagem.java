package br.unicesumar.pupil.domain.instituicao.mensagem;

import br.unicesumar.pupil.domain.instituicao.usuario.Usuario;
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
    
    private Usuario professor;

    private Usuario responsavel;
    
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm", timezone = "America/Sao_Paulo")
    private Date dataHora;
    
    @Enumerated(EnumType.STRING)
    private MensagemOrigem origem;
    
    private String texto;
    
    private boolean lidoProfessor;

    private boolean lidoResponsavel;

    public Mensagem(Usuario professor, Usuario responsavel, MensagemOrigem origem, String texto) {
        super();
        this.professor = professor;
        this.responsavel = responsavel;
        this.origem = origem;
        this.texto = texto;
    }

    
    
    
}
