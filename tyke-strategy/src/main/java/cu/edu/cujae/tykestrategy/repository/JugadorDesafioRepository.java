package cu.edu.cujae.tykestrategy.repository;

import cu.edu.cujae.tykestrategy.domain.JugadorDesafioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JugadorDesafioRepository extends JpaRepository<JugadorDesafioEntity,Long> {

    List<JugadorDesafioEntity> findAllByEstrategia_IdEstrategia(long idEstrategia);
}
