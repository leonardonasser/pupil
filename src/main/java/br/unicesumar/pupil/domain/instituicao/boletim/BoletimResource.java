package br.unicesumar.pupil.domain.instituicao.boletim;

//import br.unicesumar.pupil.domain.instituicao.usuario.TipoUsuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/boletims")
//@Secured({TipoUsuario.ADMIN_ROLE, TipoUsuario.PROFESSOR_ROLE})
public class BoletimResource {

    @Autowired
    private BoletimService service;
 
    @DeleteMapping("/{id}") 
    public void delete(@PathVariable("id") String id) {
        service.excluirPeloId(id);
    }
  
    @PutMapping("/{id}")
    public void put(@PathVariable("id") String id, @RequestBody Boletim boletimEditada) {
        service.salvar(boletimEditada);
    }


    @GetMapping("/{id}")
    public Boletim getById(@PathVariable("id") String id) {
        return service.obterPeloId(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Boletim> get() {
        return service.obterTodos();
    }

    @PostMapping
    public String post(@RequestBody Boletim nova) {
        service.salvar(nova);
        return nova.getId();
    }
}
