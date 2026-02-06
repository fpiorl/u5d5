package francescoorlando.u5d5.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "edificio")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Edificio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_edificio")
	@Setter(AccessLevel.NONE)
	private long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String indirizzo;

	@Column(nullable = false)
	private String citta;

	public Edificio(String nome, String indirizzo, String citta) {
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.citta = citta;
	}
}
