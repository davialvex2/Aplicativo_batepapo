package daviaugusto.example.aplicativo_batepapo.converter;


import daviaugusto.example.aplicativo_batepapo.dtos.response.SalaChatResponse;
import daviaugusto.example.aplicativo_batepapo.entity.SalaChat;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SalaChatConverter {


    public SalaChatResponse paraSalaChatResponse(SalaChat salaChat){
        return SalaChatResponse.builder()
                .id(salaChat.getId())
                .codigo(salaChat.getCodigo())
                .nome(salaChat.getNome())
                .usuarioPai(salaChat.getUsuarioPai())
                .build();
    }


    public List<SalaChatResponse> paraListaSalaChatResponse(List<SalaChat> salas){
        return salas.stream().map(this::paraSalaChatResponse).toList();
    }
}
