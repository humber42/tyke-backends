package cu.edu.cujae.tykestrategy.repository;

import cu.edu.cujae.tykestrategy.domain.InsigniaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsigniaRepository extends JpaRepository<InsigniaEntity,Long> {
}
