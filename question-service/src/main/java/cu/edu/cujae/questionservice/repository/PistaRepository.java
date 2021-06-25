package cu.edu.cujae.questionservice.repository;

import cu.edu.cujae.questionservice.domain.PistaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PistaRepository extends JpaRepository<PistaEntity,Long> {

}
