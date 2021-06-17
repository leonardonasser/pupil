package br.unicesumar.pupil.domain.instituicao.atividade;

import br.unicesumar.pupil.infra.exceptions.ValidationException;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AtividadeService {

    @Autowired
    private AtividadeRepository repository;
     
    public List<Atividade> obterTodos(String termoDePesquisa) {        
        if (termoDePesquisa == null || termoDePesquisa.trim().length() == 0) {
            return repository.findAll();
        }
        return repository.findByNomeLike('%'+termoDePesquisa+'%');
    }

    public Atividade obterPeloId(String id) {
        return repository.findById(id).orElseThrow(() -> new ValidationException("Atividade Não Encontrado!"));
    }

    public void excluirPeloId(String id) {
        repository.deleteById(id);
    }

    public Atividade salvar(Atividade atividade) {
        return repository.save(atividade);
    }
    
}
