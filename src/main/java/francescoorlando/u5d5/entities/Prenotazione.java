package francescoorlando.u5d5.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(
		name = "prenotazioni",
		uniqueConstraints = {
				@UniqueConstraint(columnNames = {"id_postazione", "data"}),
				@UniqueConstraint(columnNames = {"id_utente", "data"})
		}
)
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Prenotazione {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_prenotazione")
	@Setter(AccessLevel.NONE)
	private long id;

	@ManyToOne
	@JoinColumn(name = "id_postazione", nullable = false)
	private Postazione postazione;

	@ManyToOne
	@JoinColumn(name = "id_utente", nullable = false)
	private Utente utente;

	@Column(nullable = false)
	private LocalDate data;

	public Prenotazione(Postazione postazione, Utente utente, LocalDate data) {
		this.postazione = postazione;
		this.utente = utente;
		this.data = data;
	}
}
