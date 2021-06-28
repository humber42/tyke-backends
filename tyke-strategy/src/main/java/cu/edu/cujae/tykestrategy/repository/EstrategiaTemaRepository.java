package cu.edu.cujae.tykestrategy.repository;

import cu.edu.cujae.tykestrategy.domain.EstrategiaTemaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstrategiaTemaRepository extends JpaRepository<EstrategiaTemaEntity,Long> {
        List<EstrategiaTemaEntity> findAllByEstrategia_IdEstrategia(Long idEstrategia);
}

