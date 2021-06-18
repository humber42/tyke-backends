package cu.edu.cujae.tykestrategy.repository;

import cu.edu.cujae.tykestrategy.domain.RolProfesionalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolProfesionalRepository extends JpaRepository<RolProfesionalEntity, Long> {
}
