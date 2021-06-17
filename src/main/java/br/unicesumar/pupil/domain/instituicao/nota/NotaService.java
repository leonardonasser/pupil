package br.unicesumar.pupil.domain.instituicao.nota;

import br.unicesumar.pupil.infra.exceptions.ValidationException;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class NotaService {


    @Autowired
    private NotaRepository repository;
    
    public List<Nota> obterTodos() {        
            return repository.findAll();
    }

    public Nota obterPeloId(String id) {
        return repository.findById(id).orElseThrow(() -> new ValidationException("Nota N�o Encontrado!"));
    }

    public void excluirPeloId(String id) {
        repository.deleteById(id);
    }

    public Nota salvar(Nota nota) {
        return repository.save(nota);
    }
    
}
