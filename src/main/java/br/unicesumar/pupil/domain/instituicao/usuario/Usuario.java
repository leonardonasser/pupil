package br.unicesumar.pupil.domain.instituicao.usuario;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario {
    
    @EqualsAndHashCode.Include
    @Id
    private String id = UUID.randomUUID().toString();

    private String nome;

    private String cpf;

    private String email;

    private String senhaHash;
    
    private String endereco;

    private String telefone;
    
    private TipoUsuario tipoUsuario;

    public Usuario(String nome, String cpf, String email, String senhaHash, String endereco, String telefone,
            TipoUsuario tipoUsuario) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senhaHash = senhaHash;
        this.endereco = endereco;
        this.telefone = telefone;
        this.tipoUsuario = tipoUsuario;
    }

    
    
}
