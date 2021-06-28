package cu.edu.cujae.scholarManagement.repository;

import cu.edu.cujae.scholarManagement.domain.TemaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemaRepository extends JpaRepository<TemaEntity,Integer> {
    TemaEntity getTemaEntityByNombre(String nombre);
}
