package daviaugusto.example.aplicativo_batepapo.services;


import daviaugusto.example.aplicativo_batepapo.entity.Mensagem;
import daviaugusto.example.aplicativo_batepapo.entity.SalaChat;
import daviaugusto.example.aplicativo_batepapo.entity.Usuario;
import daviaugusto.example.aplicativo_batepapo.exceptions.ResourceNotFoundException;
import daviaugusto.example.aplicativo_batepapo.repositories.MensagemRepository;
import daviaugusto.example.aplicativo_batepapo.repositories.SalaChatRepository;
import daviaugusto.example.aplicativo_batepapo.repositories.UsuarioRepository;
import daviaugusto.example.aplicativo_batepapo.secutiry.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MensagemService {



    @Autowired
    private MensagemRepository mensagemRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UsuarioRepository usuarioRepository;


    public Mensagem salvarMensagem(Long idSala, String mensagem, String email){
        Mensagem mensagemEntity = new Mensagem();
        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado"));
        mensagemEntity.setMensagem(mensagem);
        mensagemEntity.setIdUsuario(usuario.getId());
        mensagemEntity.setNomeUsario(usuario.getNome());
        mensagemEntity.setTimeStamp(LocalDateTime.now());
        mensagemEntity.setSala_id(idSala);
        return mensagemRepository.save(mensagemEntity);
    }

}
