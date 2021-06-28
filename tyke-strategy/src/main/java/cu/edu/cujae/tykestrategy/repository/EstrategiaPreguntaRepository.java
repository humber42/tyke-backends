package cu.edu.cujae.tykestrategy.repository;

import cu.edu.cujae.tykestrategy.domain.EstrategiaPreguntaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstrategiaPreguntaRepository extends JpaRepository<EstrategiaPreguntaEntity,Integer> {
    List<EstrategiaPreguntaEntity> findAllByIdEstrategia(long idEstrategia);
}
