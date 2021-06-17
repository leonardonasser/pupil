package br.unicesumar.pupil.domain.instituicao.advertencia;

import br.unicesumar.pupil.infra.exceptions.ValidationException;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AdvertenciaService {

    @Autowired
    private AdvertenciaRepository repository;

    public List<Advertencia> obterTodos() {
        return repository.findAll();
    }

    public Advertencia obterPeloId(String id) {
        return repository.findById(id).orElseThrow(() -> new ValidationException("Advertencia N�o Encontrado!"));
    }

    public void excluirPeloId(String id) {
        repository.deleteById(id);
    }

    public Advertencia salvar(Advertencia advertencia) {
        return repository.save(advertencia);
    }
    
}
