package francescoorlando.u5d5.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import francescoorlando.u5d5.entities.Postazione;
import francescoorlando.u5d5.entities.Prenotazione;
import francescoorlando.u5d5.entities.Utente;
import francescoorlando.u5d5.exceptions.PrenotazioneNonValidaException;
import francescoorlando.u5d5.repositories.PrenotazioneRepository;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class PrenotazioneService {
	private final PrenotazioneRepository prenotazioneRepository;
	private final UtenteService utenteService;
	private final PostazioneService postazioneService;

	public Prenotazione creaPrenotazione(long idUtente, long idPostazione, LocalDate data) {
		Utente utente = utenteService.trovaPerId(idUtente);
		Postazione postazione = postazioneService.trovaPerId(idPostazione);

		if (prenotazioneRepository.existsByPostazioneAndUtenteAndData(postazione, utente, data)) {
			throw new PrenotazioneNonValidaException("prenotazione gia' presente per il giorno " + data);
		}

		long prenotazioniGiornaliere = prenotazioneRepository.countByPostazioneAndData(postazione, data);
		if (prenotazioniGiornaliere >= postazione.getMaxUtenti()) {
			throw new PrenotazioneNonValidaException("postazione al completo per il giorno " + data);
		}

		return prenotazioneRepository.save(new Prenotazione(postazione, utente, data));
	}
}
