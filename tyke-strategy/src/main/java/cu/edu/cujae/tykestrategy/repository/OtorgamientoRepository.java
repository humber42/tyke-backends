package cu.edu.cujae.tykestrategy.repository;

import cu.edu.cujae.tykestrategy.domain.OtorgamientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtorgamientoRepository extends JpaRepository<OtorgamientoEntity,Long> {
}
