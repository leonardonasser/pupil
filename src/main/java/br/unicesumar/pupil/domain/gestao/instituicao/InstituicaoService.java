package br.unicesumar.pupil.domain.gestao.instituicao;

import br.unicesumar.pupil.infra.exceptions.ValidationException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class InstituicaoService {

    @Autowired
    private InstituicaoRepository repository;

    public List<Instituicao> obterTodos() {
        return repository.findAll();
    }

    public Instituicao obterPeloId(String id) {
        return repository.findById(id).orElseThrow(() -> new ValidationException("Instituicao Não Encontrado!"));
    }

    public void excluirPeloId(String id) {
        repository.deleteById(id);
    }

    public Instituicao salvar(Instituicao instituicao) {
        return repository.save(instituicao);
    }
    
}
