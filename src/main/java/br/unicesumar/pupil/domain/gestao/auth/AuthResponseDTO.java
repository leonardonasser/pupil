package br.unicesumar.pupil.domain.gestao.auth;

import lombok.Data;

@Data
public class AuthResponseDTO {

    private String id;
    private String token;
    private String nome;
    
    public AuthResponseDTO(String token, String id, String nome) {
        this.token = token;
        this.id = id;
        this.nome = nome;   
    }

}
