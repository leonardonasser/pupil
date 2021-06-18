package br.unicesumar.pupil.domain.instituicao.usuario;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    List<Usuario> findByNomeLike(String nome);
    
    Usuario findBycpf(String cpf);
    
}
