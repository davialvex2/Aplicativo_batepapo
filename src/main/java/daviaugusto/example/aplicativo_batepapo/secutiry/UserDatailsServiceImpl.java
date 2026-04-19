package daviaugusto.example.aplicativo_batepapo.secutiry;


import daviaugusto.example.aplicativo_batepapo.client.UsuarioClient;
import daviaugusto.example.aplicativo_batepapo.dtos.request.LoginRequest;
import daviaugusto.example.aplicativo_batepapo.dtos.response.UsuarioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDatailsServiceImpl{


    @Autowired
    public UsuarioClient usuarioClient;

    public UserDetails loadUserByUsername(String email, String token) throws UsernameNotFoundException {
        LoginRequest loginRequest = usuarioClient.buscarUsuarioEmail(token, email);

        return User
                .withUsername(loginRequest.getEmail())
                .password(loginRequest.getSenha())
                .build();
    }
}
