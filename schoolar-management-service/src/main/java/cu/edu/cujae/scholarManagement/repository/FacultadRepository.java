package cu.edu.cujae.scholarManagement.repository;

import cu.edu.cujae.scholarManagement.domain.FacultadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultadRepository extends JpaRepository<FacultadEntity,Integer> {
    FacultadEntity getFacultadEntityByFacultad(String facultad);
    FacultadEntity getFacultadEntityBySiglas(String siglas);
}
