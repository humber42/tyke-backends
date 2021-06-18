package cu.edu.cujae.tykestrategy.repository;

import cu.edu.cujae.tykestrategy.domain.JugadorRegaloEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRegaloRepository extends JpaRepository<JugadorRegaloEntity,Long> {
}
