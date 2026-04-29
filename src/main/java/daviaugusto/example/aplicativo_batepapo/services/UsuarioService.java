package daviaugusto.example.aplicativo_batepapo.services;



import daviaugusto.example.aplicativo_batepapo.converter.SalaChatConverter;
import daviaugusto.example.aplicativo_batepapo.converter.UsuarioConverter;
import daviaugusto.example.aplicativo_batepapo.dtos.request.UsuarioRequest;
import daviaugusto.example.aplicativo_batepapo.dtos.response.SalaChatResponse;
import daviaugusto.example.aplicativo_batepapo.dtos.response.UsuarioResponse;
import daviaugusto.example.aplicativo_batepapo.entity.SalaChat;
import daviaugusto.example.aplicativo_batepapo.entity.Usuario;
import daviaugusto.example.aplicativo_batepapo.exceptions.ResourceNotFoundException;
import daviaugusto.example.aplicativo_batepapo.repositories.SalaChatRepository;
import daviaugusto.example.aplicativo_batepapo.repositories.UsuarioRepository;
import daviaugusto.example.aplicativo_batepapo.secutiry.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioConverter usuarioConverter;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SalaChatRepository salaChatRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private SalaChatConverter salaChatConverter;



    public UsuarioResponse salvarUsuario(UsuarioRequest usuarioRequest){
        Usuario usuario = usuarioConverter.paraUsuario(usuarioRequest);
        if(verificarEmail(usuario.getEmail())){
            throw new RuntimeException("Já existe um usuário com esse email");
        }
        else{
            usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
            usuarioRepository.save(usuario);
            return usuarioConverter.paraUsuarioResponse(usuario);
        }
    }

    public void conectarSala(String senha, String tokenPuro){
        String token = tokenPuro.replace("Bearer ", "");
        String email = jwtUtil.extrairEmailToken(token);
        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
        SalaChat sala = salaChatRepository.findByCodigo(senha).orElseThrow(() -> new ResourceNotFoundException("Sala não encotrada"));
        sala.getUsuarios().add(usuario);
        usuarioRepository.save(usuario);
        salaChatRepository.save(sala);
    }

    public List<SalaChatResponse> buscarSalas(String tokenPuro){
        String token = tokenPuro.substring(7).trim();
        String email = jwtUtil.extrairEmailToken(token);
        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
        return salaChatConverter.paraListaSalaChatResponse(usuario.getSalaChats());
    }



    public UsuarioResponse buscarUsuario(String email){
        return usuarioConverter.paraUsuarioResponse(usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado")));
    }


    public boolean verificarEmail(String email){
        return usuarioRepository.existsByEmail(email);
    }



}
