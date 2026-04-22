package daviaugusto.example.aplicativo_batepapo.controller;

import daviaugusto.example.aplicativo_batepapo.dtos.request.UsuarioRequest;
import daviaugusto.example.aplicativo_batepapo.entity.SalaChat;
import daviaugusto.example.aplicativo_batepapo.services.ChatService;
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

    @PostMapping
    public ResponseEntity<SalaChat> criarSala(@RequestBody UsuarioRequest usuarioRequest,
                                              @RequestHeader("Authorization") String token ){
        return ResponseEntity.status(HttpStatus.CREATED).body(chatService.criarSala(usuarioRequest));
    }


}
