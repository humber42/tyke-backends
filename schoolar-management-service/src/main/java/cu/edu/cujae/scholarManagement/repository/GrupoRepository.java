package cu.edu.cujae.scholarManagement.repository;

import cu.edu.cujae.scholarManagement.domain.GrupoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepository extends JpaRepository<GrupoEntity,Integer> {

    GrupoEntity getGrupoEntityByGrupo(String grupo);

}
