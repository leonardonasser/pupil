package br.unicesumar.pupil.domain.instituicao.usuario;

import br.unicesumar.pupil.infra.exceptions.ValidationException;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;
     
    public List<Usuario> obterTodos(String termoDePesquisa) {        
        if (termoDePesquisa == null || termoDePesquisa.trim().length() == 0) {
            return repository.findAll();
        }
        return repository.findByNomeLike('%'+termoDePesquisa+'%');
    }

    public Usuario obterPeloId(String id) {
        return repository.findById(id).orElseThrow(() -> new ValidationException("Usuario N�o Encontrado!"));
    }

    public void excluirPeloId(String id) {
        repository.deleteById(id);
    }

    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);
    }
}
