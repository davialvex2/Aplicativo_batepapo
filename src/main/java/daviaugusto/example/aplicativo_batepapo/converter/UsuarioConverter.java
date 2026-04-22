package daviaugusto.example.aplicativo_batepapo.converter;



import daviaugusto.example.aplicativo_batepapo.dtos.request.UsuarioRequest;
import daviaugusto.example.aplicativo_batepapo.dtos.response.UsuarioResponse;
import daviaugusto.example.aplicativo_batepapo.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioConverter {


  public Usuario paraUsuario(UsuarioRequest usuarioRequest){
      return Usuario.builder()
              .nome(usuarioRequest.getNome())
              .email(usuarioRequest.getEmail())
              .dataNascimento(usuarioRequest.getDataNascimento())
              .senha(usuarioRequest.getSenha())
              .build();
  }

  public UsuarioResponse paraUsuarioResponse(Usuario usuario){
      return UsuarioResponse.builder()
              .nome(usuario.getNome())
              .email(usuario.getEmail())
              .dataNascimento(usuario.getDataNascimento())
              .build();
  }

}
