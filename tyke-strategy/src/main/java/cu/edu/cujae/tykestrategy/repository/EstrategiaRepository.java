package cu.edu.cujae.tykestrategy.repository;

import cu.edu.cujae.tykestrategy.domain.EstrategiaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstrategiaRepository extends JpaRepository<EstrategiaEntity,Long> {
        Optional<EstrategiaEntity> findByNombreAndIdProfesor(String nombre,Long idProfesor);
}
