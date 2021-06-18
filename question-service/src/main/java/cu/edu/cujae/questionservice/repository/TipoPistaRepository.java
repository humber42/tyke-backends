package cu.edu.cujae.questionservice.repository;

import cu.edu.cujae.questionservice.domain.TipoPistaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPistaRepository extends JpaRepository<TipoPistaEntity,Long> {
}
