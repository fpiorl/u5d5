package francescoorlando.u5d5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import francescoorlando.u5d5.entities.Postazione;
import francescoorlando.u5d5.entities.TipoPostazione;

import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {
	@Query("SELECT p FROM Postazione p WHERE p.tipo = :tipo AND p.edificio.citta = :citta")
	List<Postazione> findByTipoAndCittaEdificio(@Param("tipo") TipoPostazione tipo, @Param("citta") String citta);
}
