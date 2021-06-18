package cu.edu.cujae.tykestrategy.repository;

import cu.edu.cujae.tykestrategy.domain.EstrategiaGrupoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstrategiaGrupoRepository extends JpaRepository<EstrategiaGrupoEntity,Long> {
}
