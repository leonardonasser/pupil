package br.unicesumar.pupil.domain.instituicao.mensagem;

import lombok.Data;

@Data
public class MensagemDTO {
	
    private MensagemOrigem origem;
    private String professorId;
    private String responsavelId;
    private String mensagem;
    
    public MensagemDTO() { }
    
    @Override
    public String toString() {
        return "MensagemDTO [origem=" + origem + ", professorId=" + professorId + ", responsavelId=" + responsavelId
                + ", mensagem=" + mensagem + "]";
    }


}
