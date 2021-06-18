package cu.edu.cujae.questionservice.repository;

import cu.edu.cujae.questionservice.domain.RespuestaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespuestaRespository extends JpaRepository<RespuestaEntity,Long> {
}
