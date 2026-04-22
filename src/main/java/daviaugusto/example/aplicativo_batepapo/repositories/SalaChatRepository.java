package daviaugusto.example.aplicativo_batepapo.repositories;

import daviaugusto.example.aplicativo_batepapo.entity.Mensagem;
import daviaugusto.example.aplicativo_batepapo.entity.SalaChat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaChatRepository extends JpaRepository<SalaChat, Long> {


}
