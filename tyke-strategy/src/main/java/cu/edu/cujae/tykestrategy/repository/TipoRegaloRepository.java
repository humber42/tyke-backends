package cu.edu.cujae.tykestrategy.repository;

import cu.edu.cujae.tykestrategy.domain.TipoRegaloEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoRegaloRepository extends JpaRepository<TipoRegaloEntity,Long> {
}
