package francescoorlando.u5d5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import francescoorlando.u5d5.entities.Edificio;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long> {
}
