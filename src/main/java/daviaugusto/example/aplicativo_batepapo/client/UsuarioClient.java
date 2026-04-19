package daviaugusto.example.aplicativo_batepapo.client;


import daviaugusto.example.aplicativo_batepapo.dtos.request.LoginRequest;
import daviaugusto.example.aplicativo_batepapo.dtos.request.UsuarioRequest;
import daviaugusto.example.aplicativo_batepapo.dtos.response.UsuarioResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {


    @PostMapping
    UsuarioResponse salvarUsuario(@RequestBody UsuarioRequest usuarioRequest);

    @PostMapping("/login")
    Map<String, String> login(@RequestBody LoginRequest login);

    @GetMapping("/{email}")
    LoginRequest buscarUsuarioEmail(@RequestHeader("Authorization") String token, @PathVariable String email);


}
