package daviaugusto.example.aplicativo_batepapo.dtos.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import daviaugusto.example.aplicativo_batepapo.entity.Mensagem;
import daviaugusto.example.aplicativo_batepapo.entity.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalaChatResponse {


    private Long id;
    private String codigo;
    private String nome;
    private Usuario usuarioPai;




}
