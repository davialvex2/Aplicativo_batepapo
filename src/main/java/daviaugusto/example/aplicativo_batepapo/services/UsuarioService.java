package daviaugusto.example.aplicativo_batepapo.services;



import daviaugusto.example.aplicativo_batepapo.converter.UsuarioConverter;
import daviaugusto.example.aplicativo_batepapo.dtos.request.UsuarioRequest;
import daviaugusto.example.aplicativo_batepapo.dtos.response.UsuarioResponse;
import daviaugusto.example.aplicativo_batepapo.entity.Usuario;
import daviaugusto.example.aplicativo_batepapo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioConverter usuarioConverter;

    @Autowired
    private PasswordEncoder passwordEncoder;


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


    public UsuarioResponse buscarUsuario(String email){
        return usuarioConverter.paraUsuarioResponse(usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado")));
    }


    public boolean verificarEmail(String email){
        return usuarioRepository.existsByEmail(email);
    }


}
