package daviaugusto.example.aplicativo_batepapo.controller;


import daviaugusto.example.aplicativo_batepapo.entity.Mensagem;
import daviaugusto.example.aplicativo_batepapo.entity.SalaChat;
import daviaugusto.example.aplicativo_batepapo.exceptions.ResourceNotFoundException;
import daviaugusto.example.aplicativo_batepapo.repositories.SalaChatRepository;
import daviaugusto.example.aplicativo_batepapo.services.MensagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.security.Principal;



@Controller
public class ChatController {

    @Autowired
    private MensagemService mensagemService;

    @Autowired
    private SalaChatRepository salaChatRepository;


    @MessageMapping("/mensagem/{sala}")
    @SendTo("/topico/chat.enviar/{sala}")
    public Mensagem enviar(@DestinationVariable String sala, @Payload Mensagem mensagem, SimpMessageHeaderAccessor accessor){
        SalaChat salaChat = salaChatRepository.findByNome(sala).orElseThrow(() -> new ResourceNotFoundException("Sala não encontrada"));
        Principal principal = accessor.getUser();
        Mensagem mensagemSalva = mensagemService.salvarMensagem(salaChat.getId(), mensagem.getMensagem(), principal.getName());
        System.out.println("Id " + mensagem.getId() + " mensagem " + mensagem.getMensagem() + " Id Usuario " + mensagem.getIdUsuario() + " Nome Usuario " + mensagem.getNomeUsuario() + " Sala Id " + mensagem.getSala_id());
        return mensagemSalva;
    }

}
