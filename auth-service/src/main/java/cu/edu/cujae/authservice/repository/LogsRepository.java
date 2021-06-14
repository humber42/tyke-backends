package cu.edu.cujae.authservice.repository;

import cu.edu.cujae.authservice.domain.LogsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogsRepository extends JpaRepository<LogsEntity, Long> {
}
