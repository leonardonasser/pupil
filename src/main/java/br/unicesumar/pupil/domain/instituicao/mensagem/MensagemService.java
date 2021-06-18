package br.unicesumar.pupil.domain.instituicao.mensagem;

import br.unicesumar.pupil.domain.instituicao.usuario.Usuario;
import br.unicesumar.pupil.domain.instituicao.usuario.UsuarioService;
import br.unicesumar.pupil.infra.exceptions.ValidationException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MensagemService {
    
    @Autowired
    private MensagemRepository mensagemRepository;
    
    @Autowired
    private UsuarioService usuarioService;
    
    public void merge(MensagemDTO mensagemDTO) {

        Usuario professor = usuarioService.obterPeloId(mensagemDTO.getProfessorId());
        if(professor == null)
            throw new ValidationException("Professor n�o localizado!");

        Usuario responsavel = usuarioService.obterPeloId(mensagemDTO.getResponsavelId());
        if(professor == null)
            throw new ValidationException("Respons�vel n�o localizado!");
        
        
        //
        Mensagem mensagem = this.merge(new Mensagem(professor, responsavel, mensagemDTO.getOrigem(), mensagemDTO.getMensagem()));
        
    }
    
    public Mensagem merge(Mensagem mensagem) {
        mensagem = mensagemRepository.save(mensagem);
        return mensagem;
    }

    public List<Mensagem> findAll() {
        return mensagemRepository.findAll();
    }

    public List<MensagemChatToDTO> findByProfessor(Integer profissonalId) {
        
        Integer naoLidas = 0;
        List<MensagemChatToDTO> mensagensChatToDTO = new ArrayList<MensagemChatToDTO>(); 
        List<Mensagem> mensagens = mensagemRepository.findByProfessorId(profissonalId); 
        
        Map<Integer, List<Mensagem>> collect = mensagens.stream().collect(Collectors.groupingBy(m -> m.getResponsavel().getId(), Collectors.toList()));
        //List<Integer> idsResponsavel = mensagens.stre
        Iterator<Integer> ite = collect.keySet().iterator();
        while(ite.hasNext()) {
            String idResponsavel = StringUtils.EMPTY;
            Usuario responsavel = usuarioService.obterPeloId(idResponsavel);
            
            List<Mensagem> mensagensResponsavel = collect.get(idResponsavel);
            List<MensagemChatDTO> mensagensResponsavelDTO = new ArrayList<MensagemChatDTO>(); 
            
            for(Mensagem mensagem: mensagensResponsavel) {
                
                MensagemChatDTO mCDTO = null;
                if(mensagem.getOrigem() == MensagemOrigem.PROFESSOR)
                    mCDTO = new MensagemChatDTO(mensagem.getDataHora(), mensagem.getTexto(), StringUtils.EMPTY);
                else
                    mCDTO = new MensagemChatDTO(mensagem.getDataHora(), StringUtils.EMPTY, mensagem.getTexto());
                
                /*
                if(!mensagem.isEntregue()) {
                    mensagem.setEntregue(true);
                    this.merge(mensagem);
                }
                */
                
                mensagensResponsavelDTO.add(mCDTO);
            }

            MensagemChatToDTO mensagemChatToDTO = new MensagemChatToDTO(new ReceptorDTO(responsavel, naoLidas), mensagensResponsavelDTO);
            mensagensChatToDTO.add(mensagemChatToDTO);
            
        }
        
        return mensagensChatToDTO;
        
    }
    
    public List<MensagemChatToDTO> findByResponsavel(Integer responsavelId) {
        
        Integer naoLidas = 0;
        List<MensagemChatToDTO> mensagensChatToDTO = new ArrayList<MensagemChatToDTO>(); 
        List<Mensagem> mensagens = mensagemRepository.findByResponsavelId(responsavelId); 
        
        Map<Integer, List<Mensagem>> collect = mensagens.stream().collect(Collectors.groupingBy(m -> m.getProfessor().getId(),Collectors.toList()));
        Iterator<Integer> ite = collect.keySet().iterator();
        while(ite.hasNext()) {
            String idProfessor = StringUtils.EMPTY;
            Usuario professor = usuarioService.obterPeloId(idProfessor);
            
            List<Mensagem> mensagensProfessor = collect.get(idProfessor);
            List<MensagemChatDTO> mensagensProfessorDTO = new ArrayList<MensagemChatDTO>(); 
            
            for(Mensagem mensagem: mensagensProfessor) {
                
                MensagemChatDTO mCDTO = null;
                if(mensagem.getOrigem() == MensagemOrigem.RESPONSAVEL)
                    mCDTO = new MensagemChatDTO(mensagem.getDataHora(), mensagem.getTexto(), StringUtils.EMPTY);
                else
                    mCDTO = new MensagemChatDTO(mensagem.getDataHora(), StringUtils.EMPTY, mensagem.getTexto());
                
                /*
                if(!mensagem.isEntregue()) {
                    mensagem.setEntregue(true);
                    this.merge(mensagem);
                }
                */
                
                mensagensProfessorDTO.add(mCDTO);
            }

            MensagemChatToDTO mensagemChatToDTO = new MensagemChatToDTO(new ReceptorDTO(professor, naoLidas), mensagensProfessorDTO);
            mensagensChatToDTO.add(mensagemChatToDTO);
            
        }
        
        return mensagensChatToDTO;
    }
    
    public List<MensagemChatDTO> findByProfessorIdAndResponsavelId(Integer profissonalId, Integer responsavelId, MensagemOrigem mensagemOrigem) {

        List<MensagemChatDTO> mensagensChatDTO = new ArrayList<MensagemChatDTO>(); 
        List<Mensagem> mensagens = mensagemRepository.findByProfessorIdAndResponsavelId(profissonalId, responsavelId); 
        for(Mensagem mensagem: mensagens) {
            
            MensagemChatDTO mCDTO = null;
            if(mensagemOrigem == mensagem.getOrigem())
                mCDTO = new MensagemChatDTO(mensagem.getDataHora(), mensagem.getTexto(), StringUtils.EMPTY);
            else
                mCDTO = new MensagemChatDTO(mensagem.getDataHora(), StringUtils.EMPTY, mensagem.getTexto());
            
            mensagensChatDTO.add(mCDTO);
            
            /*
            if(!mensagem.isEntregue()) {
                mensagem.setEntregue(true);
                this.merge(mensagem);
            }
            */
            
        }
        
        return mensagensChatDTO;
    }
}
