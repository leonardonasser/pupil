package br.unicesumar.pupil.domain.instituicao.atividade;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/atividades")
public class AtividadeResource {

    @Autowired
    private AtividadeService service;
 
    @DeleteMapping("/{id}") 
    public void delete(@PathVariable("id") String id) {
        service.excluirPeloId(id);
    }
  
    @PutMapping("/{id}")
    public void put(@PathVariable("id") String id, @RequestBody Atividade atividadeEditado) {
        service.salvar(atividadeEditado);
    }


    @GetMapping("/{id}")
    public Atividade getById(@PathVariable("id") String id) {
        return service.obterPeloId(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Atividade> get(@RequestParam(name = "termoDePesquisa", required = false) String termoDePesquisa) {
        return service.obterTodos(termoDePesquisa);
    }

    @PostMapping
    public String post(@RequestBody Atividade nova) {
        service.salvar(nova);
        return nova.getId();
    }
    
}
