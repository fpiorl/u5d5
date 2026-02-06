package francescoorlando.u5d5.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import francescoorlando.u5d5.entities.Utente;
import francescoorlando.u5d5.exceptions.ElementoNonTrovatoException;
import francescoorlando.u5d5.repositories.UtenteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UtenteService {
	private final UtenteRepository utenteRepository;

	public Utente salva(Utente utente) {
		return utenteRepository.save(utente);
	}

	public List<Utente> trovaTutti() {
		return utenteRepository.findAll();
	}

	public Utente trovaPerId(long id) {
		return utenteRepository.findById(id).orElseThrow(() -> new ElementoNonTrovatoException("Utente", id));
	}
}
