package cu.edu.cujae.scholarManagement.repository;

import cu.edu.cujae.scholarManagement.domain.GrupoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GrupoRepository extends JpaRepository<GrupoEntity,Long> {

    GrupoEntity getGrupoEntityByGrupo(String grupo);
    List<GrupoEntity> findAllByIdCarrera(int idCarrera);

}
