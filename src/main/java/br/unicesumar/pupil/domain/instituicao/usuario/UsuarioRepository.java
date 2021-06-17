package br.unicesumar.pupil.domain.instituicao.usuario;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    List<Usuario> findByNomeLike(String nome);
    
}
