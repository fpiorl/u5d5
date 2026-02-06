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

	@Override
	public void run(String... args) {

	}
}
