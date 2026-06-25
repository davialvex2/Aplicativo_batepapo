package daviaugusto.example.aplicativo_batepapo.controller;


import daviaugusto.example.aplicativo_batepapo.dtos.request.MensagemRequest;
import daviaugusto.example.aplicativo_batepapo.dtos.response.MensagemResponse;
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
    public MensagemResponse enviar(@DestinationVariable String sala, @Payload MensagemRequest mensagemRequest, SimpMessageHeaderAccessor accessor){
        SalaChat salaChat = salaChatRepository.findByNome(sala).orElseThrow(() -> new ResourceNotFoundException("Sala não encontrada"));
        Principal principal = accessor.getUser();
        MensagemResponse mensagemSalva = mensagemService.salvarMensagem(salaChat.getId(), mensagemRequest.getMensagem(), principal.getName());
        return mensagemSalva;
    }

}
