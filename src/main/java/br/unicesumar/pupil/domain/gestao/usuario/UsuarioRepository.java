package br.unicesumar.pupil.domain.gestao.usuario;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    List<Usuario> findByNomeLike(String nome);
    
}
