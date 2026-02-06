package francescoorlando.u5d5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import francescoorlando.u5d5.entities.Postazione;
import francescoorlando.u5d5.entities.Prenotazione;
import francescoorlando.u5d5.entities.Utente;

import java.time.LocalDate;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
	boolean existsByPostazioneAndUtenteAndData(Postazione postazione, Utente utente, LocalDate data);

	long countByPostazioneAndData(Postazione postazione, LocalDate data);
}
