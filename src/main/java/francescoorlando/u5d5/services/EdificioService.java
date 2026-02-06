package francescoorlando.u5d5.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import francescoorlando.u5d5.entities.Edificio;
import francescoorlando.u5d5.exceptions.ElementoNonTrovatoException;
import francescoorlando.u5d5.repositories.EdificioRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EdificioService {
	private final EdificioRepository edificioRepository;

	public Edificio salva(Edificio edificio) {
		return edificioRepository.save(edificio);
	}

	public List<Edificio> trovaTutti() {
		return edificioRepository.findAll();
	}

	public Edificio trovaPerId(long id) {
		return edificioRepository.findById(id).orElseThrow(() -> new ElementoNonTrovatoException("Edificio", id));
	}
}
