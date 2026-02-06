package francescoorlando.u5d5.runners;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import francescoorlando.u5d5.entities.*;
import francescoorlando.u5d5.exceptions.PrenotazioneNonValidaException;
import francescoorlando.u5d5.services.*;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {
	private final UtenteService utenteService;
	private final EdificioService edificioService;
	private final PostazioneService postazioneService;
	private final PrenotazioneService prenotazioneService;

	@Override
	public void run(String... args) {
		Edificio edificio = edificioService.salva(new Edificio("Sede Centrale", "Via Spezia 1b", "Cerignola"));
		Postazione postazione = postazioneService.salva(new Postazione("Open space", TipoPostazione.OPENSPACE, 2, edificio));
		Utente utente1 = utenteService.salva(new Utente("Ilaria Salis", "occupyyourstreet", "salis@bur.go"));
		Utente utente2 = utenteService.salva(new Utente("Varg Vikernes", "bzum", "asdadssa@mail.it"));
		Utente utente3 = utenteService.salva(new Utente("Anna Bianchi", "abianchi", "anna@mail.it"));

		LocalDate oggi = LocalDate.now();

		System.out.println("Postazioni OPENSPACE a Cerignola: " + postazioneService.findByTipoAndCitta(TipoPostazione.OPENSPACE, "Cerignola"));
		System.out.println("Creo prenotazioni sulla stessa postazione...");
		System.out.println(prenotazioneService.creaPrenotazione(utente1.getId(), postazione.getId(), oggi));
		System.out.println(prenotazioneService.creaPrenotazione(utente2.getId(), postazione.getId(), oggi));

		System.out.println("Provo a superare la capienza...");
		try {
			System.out.println(prenotazioneService.creaPrenotazione(utente3.getId(), postazione.getId(), oggi));
		} catch (PrenotazioneNonValidaException e) {
			System.out.println(e.getMessage());
		}
	}
}
