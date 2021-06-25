package cu.edu.cujae.questionservice.repository;

import cu.edu.cujae.questionservice.domain.PreguntaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreguntaRepository extends JpaRepository<PreguntaEntity,Long> {

}
