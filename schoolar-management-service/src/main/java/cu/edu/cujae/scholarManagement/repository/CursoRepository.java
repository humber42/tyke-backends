package cu.edu.cujae.scholarManagement.repository;

import cu.edu.cujae.scholarManagement.domain.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<CursoEntity,Integer> {

    CursoEntity getCursoEntityByActivoIsTrue();
    CursoEntity getCursoEntityByCurso(String curso);
}
