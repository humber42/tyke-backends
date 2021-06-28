package cu.edu.cujae.tykestrategy.repository;

import cu.edu.cujae.tykestrategy.domain.EstrategiaGrupoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstrategiaGrupoRepository extends JpaRepository<EstrategiaGrupoEntity,Long> {
    List<EstrategiaGrupoEntity> findAllByEstrategia_IdEstrategia(long idEstrategia);
}
