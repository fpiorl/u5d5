package francescoorlando.u5d5.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "utenti")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Utente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_utente")
	@Setter(AccessLevel.NONE)
	private long id;

	@Column(name = "nome", nullable = false)
	private String fullName;

	@Column(nullable = false)
	private String username;

	@Column(nullable = false)
	private String email;

	public Utente(String fullName, String username, String email) {
		this.fullName = fullName;
		this.username = username;
		this.email = email;
	}
}
