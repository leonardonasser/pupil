package br.unicesumar.pupil.domain.gestao.instituicao;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Instituicao {
    
    @EqualsAndHashCode.Include
    @Id
    private String id = UUID.randomUUID().toString();
    
    private String nomeComercial;
    
    private String cnpj;
    
    private String email;
    
    private String pessoaDeContato;
   
    private String instance;

    private String endereco;

    private String telefone;

    private String celular;

    private Boolean active = false;

    private LocalDateTime createdAt = LocalDateTime.now();

}
