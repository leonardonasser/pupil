package br.unicesumar.pupil.domain.instituicao.frequencia;

import br.unicesumar.pupil.infra.exceptions.ValidationException;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FrequenciaService {

    @Autowired
    private FrequenciaRepository repository;

    public List<Frequencia> obterTodos() {
        return repository.findAll();
    }

    public Frequencia obterPeloId(String id) {
        return repository.findById(id).orElseThrow(() -> new ValidationException("Frequencia Não Encontrado!"));
    }

    public void excluirPeloId(String id) {
        repository.deleteById(id);
    }

    public Frequencia salvar(Frequencia frequencia) {
        return repository.save(frequencia);
    }

}
