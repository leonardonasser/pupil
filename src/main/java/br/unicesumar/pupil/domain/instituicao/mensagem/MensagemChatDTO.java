package br.unicesumar.pupil.domain.instituicao.mensagem;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MensagemChatDTO {
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm", timezone = "America/Sao_Paulo")
	private Date dataHora;
	
	private String mensagemEnviada;
	private String mensagemRecebida;
	
	public MensagemChatDTO(Date dataHora, String mensagemEnviada, String mensagemRecebida) {
		super();
		this.dataHora = dataHora;
		this.mensagemEnviada = mensagemEnviada;
		this.mensagemRecebida = mensagemRecebida;
	}
	
	public Date getDataHora() {
		return dataHora;
	}
	
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	
	public String getMensagemEnviada() {
		return mensagemEnviada;
	}
	
	public void setMensagemEnviada(String mensagemEnviada) {
		this.mensagemEnviada = mensagemEnviada;
	}
	
	public String getMensagemRecebida() {
		return mensagemRecebida;
	}
	
	public void setMensagemRecebida(String mensagemRecebida) {
		this.mensagemRecebida = mensagemRecebida;
	}
	
	@Override
	public String toString() {
		return "MensagemChatDTO [dataHora=" + dataHora + ", mensagemEnviada=" + mensagemEnviada + ", mensagemRecebida="
				+ mensagemRecebida + "]";
	}
	

}
