package daviaugusto.example.aplicativo_batepapo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

public class Mensagem {

    private String autor;
    private String mensagem;


    public Mensagem() {
    }

    public Mensagem(String autor, String mensagem) {
        this.autor = autor;
        this.mensagem = mensagem;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
