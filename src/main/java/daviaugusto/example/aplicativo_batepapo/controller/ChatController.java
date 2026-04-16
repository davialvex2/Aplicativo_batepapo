package daviaugusto.example.aplicativo_batepapo.controller;


import daviaugusto.example.aplicativo_batepapo.entity.Mensagem;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
public class ChatController {


    @MessageMapping("/mensagem")
    @SendTo("/topico/chat")
    public Mensagem enviar(Mensagem mensagem){
        return mensagem;
    }
}
