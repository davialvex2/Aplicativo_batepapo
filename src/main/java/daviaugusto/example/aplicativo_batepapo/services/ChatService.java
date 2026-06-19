package daviaugusto.example.aplicativo_batepapo.services;

import daviaugusto.example.aplicativo_batepapo.converter.SalaChatConverter;
import daviaugusto.example.aplicativo_batepapo.dtos.request.SalaRequestRecord;
import daviaugusto.example.aplicativo_batepapo.dtos.request.UsuarioRequest;
import daviaugusto.example.aplicativo_batepapo.dtos.response.SalaChatResponse;
import daviaugusto.example.aplicativo_batepapo.entity.Mensagem;
import daviaugusto.example.aplicativo_batepapo.entity.SalaChat;
import daviaugusto.example.aplicativo_batepapo.entity.Usuario;
import daviaugusto.example.aplicativo_batepapo.exceptions.ResourceNotFoundException;
import daviaugusto.example.aplicativo_batepapo.repositories.SalaChatRepository;
import daviaugusto.example.aplicativo_batepapo.repositories.UsuarioRepository;
import daviaugusto.example.aplicativo_batepapo.secutiry.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ChatService {


    @Autowired
    private SalaChatRepository salaChatRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private SalaChatConverter salaChatConverter;


    public SalaChatResponse criarSala(String nome, String tokenPuro) {
        String token = tokenPuro.substring(7).trim();
        String email = jwtUtil.extrairEmailToken(token);
        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        SalaChat sala = new SalaChat();
        sala.setCodigo(criarCodigo());
        sala.setUsuarioPai(usuario);
        sala.setNome(nome);
        List<Usuario> listaUsuarios = sala.getUsuarios();
        listaUsuarios.add(usuario);
        sala.setUsuarios(listaUsuarios);
        return salaChatConverter.paraSalaChatResponse(salaChatRepository.save(sala));
    }


    public String criarCodigo() {
        String conteudo = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder sb = new StringBuilder(10);
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(conteudo.length());
            sb.append(conteudo.charAt(index));
        }
        return sb.toString();
    }


    public List<Mensagem> buscarSalaComMensagens(String nome) {
        SalaChat sala = salaChatRepository.findByNome(nome).orElseThrow(() -> new ResourceNotFoundException("Sala não encontrada"));
        return sala.getMensagens();
    }

}
