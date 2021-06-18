package br.unicesumar.pupil.domain.instituicao.mensagem;

import br.unicesumar.pupil.domain.instituicao.usuario.Usuario;

public class ReceptorDTO {
	
	private String id;
	private String nome;
	private Integer naoLidas;
	
	public ReceptorDTO(Usuario obj, Integer naoLidas) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.naoLidas = naoLidas;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public Integer getNaoLidas() {
		return naoLidas;
	}

	public void setNaoLidas(Integer naoLidas) {
		this.naoLidas = naoLidas;
	}

	@Override
	public String toString() {
		return "ReceptorDTO [id=" + id + ", nome=" + nome + ", imagemPerfil=" + ", naoLidas=" + naoLidas
				+ "]";
	}
	
}
