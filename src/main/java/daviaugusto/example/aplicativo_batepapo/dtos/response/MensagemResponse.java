package daviaugusto.example.aplicativo_batepapo.dtos.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class MensagemResponse {

    private String nomeUsuario;
    private Long idUsuario;
    private String mensagem;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime timeStamp;


    public MensagemResponse(){
    }

    public MensagemResponse(String nomeUsuario, Long idUsuario, String mensagem, LocalDateTime timeStamp){
        this.nomeUsuario = nomeUsuario;
        this.idUsuario = idUsuario;
        this.mensagem = mensagem;
        this.timeStamp = timeStamp;
    }

    public void setNomeUsuario(String nomeUsuario){
        this.nomeUsuario = nomeUsuario;
    }

    public String getNomeUsuario(){
        return nomeUsuario;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
