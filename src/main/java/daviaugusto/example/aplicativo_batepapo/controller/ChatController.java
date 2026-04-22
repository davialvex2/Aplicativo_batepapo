package daviaugusto.example.aplicativo_batepapo.controller;


import daviaugusto.example.aplicativo_batepapo.entity.Mensagem;
import daviaugusto.example.aplicativo_batepapo.entity.SalaChat;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ChatController {


    @MessageMapping("/mensagem/{sala}")
    @SendTo("/topico/chat/{sala}")
    public Mensagem enviar(@PathVariable String sala, Mensagem mensagem){
        return mensagem;
    }

}
