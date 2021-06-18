package br.unicesumar.pupil.domain.instituicao.auth;

import br.unicesumar.pupil.domain.instituicao.usuario.Usuario;
import br.unicesumar.pupil.domain.instituicao.usuario.UsuarioService;
import br.unicesumar.pupil.exception.InvalidCredentialsException;
import br.unicesumar.pupil.security.JWTUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder pe;

    @Autowired
    private JWTUtil jwtUtil;

    @ApiOperation("endpoint de login")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthCredenciaisDTO obj) {

        Usuario usuario = usuarioService.obterPeloCpf(obj.getCpf());

        if (usuario == null || !pe.matches(obj.getSenha(), usuario.getSenhaHash()))
            throw new InvalidCredentialsException("Email ou senha invalida");

        String token = jwtUtil.generateToken(obj.getCpf());

        AuthResponseDTO tokenClass = new AuthResponseDTO("Bearer " + token, usuario.getId(), usuario.getNome());
        return ResponseEntity.ok().body(tokenClass);
    }

}
