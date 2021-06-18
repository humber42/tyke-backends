package cu.edu.cujae.scholarManagement.repository;

import cu.edu.cujae.scholarManagement.domain.EstudianteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<EstudianteEntity,Integer> {

}
