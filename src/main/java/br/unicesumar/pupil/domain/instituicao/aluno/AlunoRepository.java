package br.unicesumar.pupil.domain.instituicao.aluno;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, String> {

    List<Aluno> findByNomeLike(String nome);
    
}
