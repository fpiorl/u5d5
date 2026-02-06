package francescoorlando.u5d5.exceptions;

/* ENOENT */
public class ElementoNonTrovatoException extends RuntimeException {
	public ElementoNonTrovatoException(String elem, long id) {
		super(elem + " con id " + id + " non trovato");
	}
}
