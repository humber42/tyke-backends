package cu.edu.cujae.scholarManagement.repository;

import cu.edu.cujae.scholarManagement.domain.CarreraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarreraRepository extends JpaRepository<CarreraEntity,Integer> {

    CarreraEntity findCarreraEntityByNombre(String nombre);
    CarreraEntity findCarreraEntityBySiglas(String siglas);
    List<CarreraEntity> findCarreraEntitiesByFacultadByIdFacultad_Facultad(String facultad);


}
