package daviaugusto.example.aplicativo_batepapo.controller;

import daviaugusto.example.aplicativo_batepapo.dtos.request.SalaRequestRecord;
import daviaugusto.example.aplicativo_batepapo.dtos.request.UsuarioRequest;
import daviaugusto.example.aplicativo_batepapo.dtos.response.SalaChatResponse;
import daviaugusto.example.aplicativo_batepapo.entity.Mensagem;
import daviaugusto.example.aplicativo_batepapo.entity.SalaChat;
import daviaugusto.example.aplicativo_batepapo.services.ChatService;
import daviaugusto.example.aplicativo_batepapo.services.MensagemService;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sala")
public class SalaController {


    @Autowired
    private ChatService chatService;

    @Autowired
    private MensagemService mensagemService;

    @PostMapping
    public ResponseEntity<SalaChatResponse> criarSala(@RequestBody SalaRequestRecord sala, @RequestHeader("Authorization") String token ){
        return ResponseEntity.status(HttpStatus.CREATED).body(chatService.criarSala(sala.nome(), token));
    }

    /*@PostMapping("/{idSala}")
    public ResponseEntity<Void> salvarMensagem(@PathVariable Long idSala, @RequestBody Mensagem mensagem, @RequestHeader("Authorization") String token){
        mensagemService.salvarMensagem(idSala, mensagem.getMensagem(), token);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }*/




}
