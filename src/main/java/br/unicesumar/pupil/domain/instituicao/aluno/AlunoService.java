package br.unicesumar.pupil.domain.instituicao.aluno;

import br.unicesumar.pupil.infra.exceptions.ValidationException;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AlunoService {

    @Autowired
    private AlunoRepository repository;
    
    
    public List<Aluno> obterTodosPaginando(String termoDePesquisa) {        
        if (termoDePesquisa == null || termoDePesquisa.trim().length() == 0) {
            return repository.findAll();
        }
        return repository.findByNomeLike('%'+termoDePesquisa+'%');
    }

    public Aluno obterPeloId(String id) {
        return repository.findById(id).orElseThrow(() -> new ValidationException("Aluno N�o Encontrado!"));
    }

    public void excluirPeloId(String id) {
        repository.deleteById(id);
    }

    public Aluno salvar(Aluno aluno) {
        return repository.save(aluno);
    }
    
}
