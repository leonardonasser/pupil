package br.unicesumar.pupil.domain.instituicao.mensagem;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/mensagens")
public class MensagemResource {

	@Autowired
	private MensagemService mensagemService;
	
	@ApiOperation("Recuperar mensagem de um agendamento")
	@RequestMapping(value = "/professor/{idProfessor}/responsavel/{idResponsavel}/origem/{mensagemOrigem}", method = RequestMethod.GET)
	public ResponseEntity<List<MensagemChatDTO>> findByAgendamento(@PathVariable Integer idProfssional, @PathVariable Integer idResponsavel, @PathVariable MensagemOrigem mensagemOrigem) {
		
		List<MensagemChatDTO> mensagensChatDTO = mensagemService.findByProfessorIdAndResponsavelId(idProfssional, idResponsavel, mensagemOrigem); 
		return ResponseEntity.ok().body(mensagensChatDTO);
	}
	
	@ApiOperation("Recuperar mensagem de professor")
	@RequestMapping(value = "/professor/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<MensagemChatToDTO>> findByProfessor(@PathVariable Integer id) {
		List<MensagemChatToDTO> mensagensChatToDTO = mensagemService.findByProfessor(id); 
		return ResponseEntity.ok().body(mensagensChatToDTO);
		
	}

	@ApiOperation("Recuperar mensagem de responsavel")
	@RequestMapping(value = "/responsavel/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<MensagemChatToDTO>> findByResponsavel(@PathVariable Integer id) {
		List<MensagemChatToDTO> mensagensChatToDTO = mensagemService.findByResponsavel(id); 
		return ResponseEntity.ok().body(mensagensChatToDTO);
	}
	
	@ApiOperation("Inseri uma nova mensagem")
	@PreAuthorize("hasAnyRole('ADMIN', 'RESPONSAVEL', 'PROFESSOR')")
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody MensagemDTO obj) {
		mensagemService.merge(obj);
		return ResponseEntity.noContent().build();
	}
	
}