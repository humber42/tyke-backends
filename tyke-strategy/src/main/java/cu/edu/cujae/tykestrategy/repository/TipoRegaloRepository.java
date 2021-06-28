package cu.edu.cujae.tykestrategy.repository;

import cu.edu.cujae.tykestrategy.domain.TipoRegaloEntity;
import cu.edu.cujae.tykestrategy.dto.TipoRegaloDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoRegaloRepository extends JpaRepository<TipoRegaloEntity,Long> {
    Optional<TipoRegaloEntity> findByNombre(String nombre);
}
