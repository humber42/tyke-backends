package cu.edu.cujae.scholarManagement.repository;

import cu.edu.cujae.scholarManagement.domain.EstudianteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstudianteRepository extends JpaRepository<EstudianteEntity,Integer> {

}
