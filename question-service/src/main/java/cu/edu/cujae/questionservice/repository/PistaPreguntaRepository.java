package cu.edu.cujae.questionservice.repository;

import cu.edu.cujae.questionservice.domain.PistaPreguntaEntity;
import cu.edu.cujae.questionservice.domain.PistaPreguntaEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PistaPreguntaRepository extends JpaRepository<PistaPreguntaEntity, PistaPreguntaEntityPK> {
}
