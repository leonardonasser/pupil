package br.unicesumar.pupil.domain.instituicao.boletim;

import br.unicesumar.pupil.infra.exceptions.ValidationException;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BoletimService {

    @Autowired
    private BoletimRepository repository;
    
    
    public List<Boletim> obterTodos() {        
            return repository.findAll();
    }

    public Boletim obterPeloId(String id) {
        return repository.findById(id).orElseThrow(() -> new ValidationException("Boletim N�o Encontrado!"));
    }

    public void excluirPeloId(String id) {
        repository.deleteById(id);
    }

    public Boletim salvar(Boletim boletim) {
        return repository.save(boletim);
    }
    
}
