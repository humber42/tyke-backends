package cu.edu.cujae.scholarManagement.repository;

import cu.edu.cujae.scholarManagement.domain.AsignaturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsignaturaRepository extends JpaRepository<AsignaturaEntity,Integer> {


    AsignaturaEntity findByNombre(String nombre);
    List<AsignaturaEntity> findAllByActivoIsTrue();
}
