package daviaugusto.example.aplicativo_batepapo.dtos.response;



import lombok.Builder;

import java.time.LocalDate;

@Builder
public class UsuarioResponse {

    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String email;


    public UsuarioResponse() {
    }

    public UsuarioResponse(Long id, String nome, LocalDate dataNascimento, String email) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
