package daviaugusto.example.aplicativo_batepapo.repositories;

import daviaugusto.example.aplicativo_batepapo.entity.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensagemRepository extends JpaRepository<Mensagem, Long> {


}
