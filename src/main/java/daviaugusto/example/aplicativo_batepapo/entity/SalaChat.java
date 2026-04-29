package daviaugusto.example.aplicativo_batepapo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import daviaugusto.example.aplicativo_batepapo.dtos.request.UsuarioRequest;
import jakarta.persistence.*;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
public class SalaChat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String codigo;
    @OneToMany
    @JoinColumn(name = "sala_id", referencedColumnName = "id")
    private List<Mensagem> mensagens = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "tb_usuarios", joinColumns = @JoinColumn(name = "sala_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id"))
    private List<Usuario> usuarios = new ArrayList<>();
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "usuarioPai_id")
    private Usuario usuarioPai;


    public SalaChat() {
    }

    public SalaChat(Long id, String codigo, String nome, List<Mensagem> mensagens, List<Usuario> usuarios, Usuario usuarioPai) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.mensagens = mensagens;
        this.usuarios = usuarios;
        this.usuarioPai = usuarioPai;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Mensagem> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getUsuarioPai() {
        return usuarioPai;
    }

    public void setUsuarioPai(Usuario usuarioPai) {
        this.usuarioPai = usuarioPai;
    }
}
