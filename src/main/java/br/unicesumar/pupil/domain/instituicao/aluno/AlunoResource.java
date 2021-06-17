package br.unicesumar.pupil.domain.instituicao.aluno;

import br.unicesumar.pupil.domain.instituicao.usuario.TipoUsuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/alunos")
@PreAuthorize(TipoUsuario.ADMIN_ROLE)
public class AlunoResource {

    @Autowired
    private AlunoService service;
 
    @DeleteMapping("/{id}") 
    public void delete(@PathVariable("id") String id) {
        service.excluirPeloId(id);
    }
  
    @PutMapping("/{id}")
    public void put(@PathVariable("id") String id, @RequestBody Aluno alunoEditada) {
        service.salvar(alunoEditada);
    }


    @GetMapping("/{id}")
    public Aluno getById(@PathVariable("id") String id) {
        return service.obterPeloId(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Aluno> get(@RequestParam(name = "termoDePesquisa", required = false) String termoDePesquisa) {
        return service.obterTodosPaginando(termoDePesquisa);
    }

    @PostMapping
    public String post(@RequestBody Aluno nova) {
        service.salvar(nova);
        return nova.getId();
    }
    
}
