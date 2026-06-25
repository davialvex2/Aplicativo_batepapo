package daviaugusto.example.aplicativo_batepapo.dtos.request;

import lombok.Builder;

@Builder
public class MensagemRequest {

    private String mensagem;


    public MensagemRequest(){
    }

    public MensagemRequest(String mensagem){
        this.mensagem = mensagem;
    }

    public void setMensagem(String mensagem){
        this.mensagem = mensagem;
    }

    public String getMensagem(){
        return mensagem;
    }


}
