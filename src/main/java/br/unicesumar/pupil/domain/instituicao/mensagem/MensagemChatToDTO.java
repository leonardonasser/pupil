package br.unicesumar.pupil.domain.instituicao.mensagem;

import java.util.List;

public class MensagemChatToDTO {
	
	private ReceptorDTO receptor;
	
	List<MensagemChatDTO> mensagens;
	
	public MensagemChatToDTO(ReceptorDTO receptor, List<MensagemChatDTO> mensagens) {
		super();
		this.receptor = receptor;
		this.mensagens = mensagens;
	}

	public ReceptorDTO getReceptor() {
		return receptor;
	}

	public void setReceptor(ReceptorDTO receptor) {
		this.receptor = receptor;
	}

	public List<MensagemChatDTO> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<MensagemChatDTO> mensagens) {
		this.mensagens = mensagens;
	}

	@Override
	public String toString() {
		return "MensagemChatToDTO [receptor=" + receptor + ", mensagens=" + mensagens + "]";
	}
	
}
