package cu.edu.cujae.tykestrategy.repository;

import cu.edu.cujae.tykestrategy.domain.JugadorEstrategiaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorEstrategiaRepository extends JpaRepository<JugadorEstrategiaEntity,Long> {
}
