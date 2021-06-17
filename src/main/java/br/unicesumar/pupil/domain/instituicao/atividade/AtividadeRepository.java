package br.unicesumar.pupil.domain.instituicao.atividade;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtividadeRepository extends JpaRepository<Atividade, String>{

    List<Atividade> findByNomeLike(String nome);
    
}
