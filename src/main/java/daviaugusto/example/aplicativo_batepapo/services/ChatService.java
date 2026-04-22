package daviaugusto.example.aplicativo_batepapo.services;

import daviaugusto.example.aplicativo_batepapo.dtos.request.UsuarioRequest;
import daviaugusto.example.aplicativo_batepapo.entity.SalaChat;
import daviaugusto.example.aplicativo_batepapo.repositories.SalaChatRepository;
import daviaugusto.example.aplicativo_batepapo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ChatService {


    @Autowired
    private SalaChatRepository salaChatRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;



  public SalaChat criarSala(UsuarioRequest usuario){
        SalaChat sala = new SalaChat();
        return salaChatRepository.save(sala);
   }


    public String criarCodigo(){
        String conteudo = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder sb = new StringBuilder(10);
        Random random = new Random();

        for(int i =0; i<10; i++){
            int index = random.nextInt(conteudo.length());
            sb.append(conteudo.charAt(index));
        }
        return sb.toString();
    }

}
