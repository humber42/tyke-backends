package cu.edu.cujae.tykestrategy.repository;

import cu.edu.cujae.tykestrategy.domain.JugadorInsigniaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorInsigniaRepository extends JpaRepository<JugadorInsigniaEntity,Long> {
}
