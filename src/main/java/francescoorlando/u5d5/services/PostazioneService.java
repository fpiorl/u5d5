package francescoorlando.u5d5.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import francescoorlando.u5d5.entities.Postazione;
import francescoorlando.u5d5.entities.TipoPostazione;
import francescoorlando.u5d5.exceptions.ElementoNonTrovatoException;
import francescoorlando.u5d5.repositories.PostazioneRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostazioneService {
	private final PostazioneRepository postazioneRepository;

	public Postazione salva(Postazione postazione) {
		return postazioneRepository.save(postazione);
	}

	public List<Postazione> trovaTutte() {
		return postazioneRepository.findAll();
	}

	public Postazione trovaPerId(long id) {
		return postazioneRepository.findById(id).orElseThrow(() -> new ElementoNonTrovatoException("Postazione", id));
	}

	public List<Postazione> findByTipoAndCitta(TipoPostazione tipo, String citta) {
		return postazioneRepository.findByTipoAndCittaEdificio(tipo, citta);
	}
}
