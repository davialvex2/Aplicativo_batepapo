package daviaugusto.example.aplicativo_batepapo.controller;



import daviaugusto.example.aplicativo_batepapo.dtos.request.LoginRequest;
import daviaugusto.example.aplicativo_batepapo.dtos.request.UsuarioRequest;
import daviaugusto.example.aplicativo_batepapo.dtos.response.SalaChatResponse;
import daviaugusto.example.aplicativo_batepapo.dtos.response.UsuarioResponse;
import daviaugusto.example.aplicativo_batepapo.entity.SalaChat;
import daviaugusto.example.aplicativo_batepapo.secutiry.JwtUtil;
import daviaugusto.example.aplicativo_batepapo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {


    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService usuarioService;


    @PostMapping
    public ResponseEntity<?> salvarUsuario(@RequestBody UsuarioRequest usuarioRequest){
        UsuarioResponse usuarioResponse = usuarioService.salvarUsuario(usuarioRequest);
        return ResponseEntity.ok("Usuário cadastrado com sucesso");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest login){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login.getEmail(), login.getSenha()));
            String token  = "Bearer " + jwtUtil.gerarToken(authentication.getName());
            return ResponseEntity.ok(Map.of("token" , token));
    }

    @GetMapping
    public ResponseEntity<UsuarioResponse> buscarUsuarioEmail(@RequestParam("email") String email){
        return ResponseEntity.ok(usuarioService.buscarUsuario(email));
    }

    @PostMapping("/conectar")
    public ResponseEntity<Void> concetarSala(@RequestParam("senha") String senha, @RequestHeader("Authorization") String token){
        usuarioService.conectarSala(senha, token);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/salas")
    public ResponseEntity<List<SalaChatResponse>> buscarSalasConectadas(@RequestHeader("Authorization") String token){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.buscarSalas(token));
    }







}
