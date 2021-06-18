package cu.edu.cujae.questionservice.repository;

import cu.edu.cujae.questionservice.domain.TipoPreguntaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPreguntaRepository extends JpaRepository<TipoPreguntaEntity,Long> {
}
