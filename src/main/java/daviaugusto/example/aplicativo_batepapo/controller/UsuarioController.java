package daviaugusto.example.aplicativo_batepapo.controller;


import daviaugusto.example.aplicativo_batepapo.client.UsuarioClient;
import daviaugusto.example.aplicativo_batepapo.dtos.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    
    @Autowired
    public UsuarioClient usuarioClient;


    @PostMapping
    public ResponseEntity<Map<String, String>> login (@RequestBody LoginRequest login){
        return ResponseEntity.ok().body(usuarioClient.login(login));
    }
}
