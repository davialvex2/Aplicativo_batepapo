package daviaugusto.example.aplicativo_batepapo.entity;


import daviaugusto.example.aplicativo_batepapo.dtos.request.UsuarioRequest;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class SalaChat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    @OneToMany
    @JoinColumn(name = "sala_id", referencedColumnName = "id")
    private List<Mensagem> mensagens = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "tb_usuarios", joinColumns = @JoinColumn(name = "sala_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id"))
    private List<Usuario> usuarios = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "usuarioPai_id")
    private Usuario usuarioPai;


    public SalaChat() {
    }


}
