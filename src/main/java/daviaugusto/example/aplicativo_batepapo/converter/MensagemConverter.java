package daviaugusto.example.aplicativo_batepapo.converter;


import daviaugusto.example.aplicativo_batepapo.dtos.request.MensagemRequest;
import daviaugusto.example.aplicativo_batepapo.dtos.response.MensagemResponse;
import daviaugusto.example.aplicativo_batepapo.entity.Mensagem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MensagemConverter {


    public MensagemResponse paraMensagemResponse(Mensagem mensagem){
        return MensagemResponse.builder()
                .mensagem(mensagem.getMensagem())
                .idUsuario(mensagem.getIdUsuario())
                .nomeUsuario(mensagem.getNomeUsuario())
                .timeStamp(mensagem.getTimeStamp())
                .build();

    }

    public Mensagem paraMensagemEntity(MensagemRequest mensagemRequest){
        return Mensagem.builder()
                .mensagem(mensagemRequest.getMensagem())
                .build();
    }


    public List<MensagemResponse> paraListaMensagemResponse(List<Mensagem> listaMensagem){
        return listaMensagem.stream().map(this::paraMensagemResponse).toList();
    }




}
