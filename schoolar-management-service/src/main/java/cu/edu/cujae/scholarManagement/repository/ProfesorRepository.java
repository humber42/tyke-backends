package cu.edu.cujae.scholarManagement.repository;

import cu.edu.cujae.scholarManagement.domain.ProfesorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfesorRepository extends JpaRepository<ProfesorEntity,Integer>
{

}
