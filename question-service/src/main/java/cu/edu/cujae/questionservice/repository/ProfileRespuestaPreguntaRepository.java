package cu.edu.cujae.questionservice.repository;

import cu.edu.cujae.questionservice.domain.ProfileRespuestaPreguntaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRespuestaPreguntaRepository extends JpaRepository<ProfileRespuestaPreguntaEntity,Long> {
}
