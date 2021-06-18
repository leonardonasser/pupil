package br.unicesumar.pupil.domain.instituicao.mensagem;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensagemRepository extends JpaRepository<Mensagem, Integer>{
    
    List<Mensagem> findByProfessorId(Integer idProfissoinal);

    List<Mensagem> findByResponsavelId(Integer idResponsavel);

    List<Mensagem> findByProfessorIdAndResponsavelId(Integer idProfissoinal, Integer idResponsavel);
    
}