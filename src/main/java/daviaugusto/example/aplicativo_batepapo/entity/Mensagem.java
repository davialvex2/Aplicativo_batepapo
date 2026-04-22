package daviaugusto.example.aplicativo_batepapo.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Mensagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idUsuario;
    private String nomeUsario;
    private LocalDateTime timeStamp;
    private String mensagem;
    @Column(name = "sala_id")
    private Long sala_id;


    public Mensagem() {
    }

    public Mensagem(Long id, Long idUsuario, String nomeUsario, LocalDateTime timeStamp, String mensagem, Long sala_id) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.nomeUsario = nomeUsario;
        this.timeStamp = timeStamp;
        this.mensagem = mensagem;
        this.sala_id = sala_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsario() {
        return nomeUsario;
    }

    public void setNomeUsario(String nomeUsario) {
        this.nomeUsario = nomeUsario;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Long getSala_id() {
        return sala_id;
    }

    public void setSala_id(Long sala_id) {
        this.sala_id = sala_id;
    }
}




