package francescoorlando.u5d5.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "postazione")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Postazione {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_postazione")
	@Setter(AccessLevel.NONE)
	private long id;

	@Column(name = "\"desc\"", nullable = false)
	private String descrizione;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TipoPostazione tipo;

	@Column(name = "maxusers", nullable = false)
	private long maxUtenti;

	@ManyToOne
	@JoinColumn(name = "id_edificio", nullable = false)
	private Edificio edificio;

	public Postazione(String descrizione, TipoPostazione tipo, long maxUtenti, Edificio edificio) {
		this.descrizione = descrizione;
		this.tipo = tipo;
		this.maxUtenti = maxUtenti;
		this.edificio = edificio;
	}
}
