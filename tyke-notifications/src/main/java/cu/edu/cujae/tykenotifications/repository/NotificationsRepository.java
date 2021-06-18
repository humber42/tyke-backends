package cu.edu.cujae.tykenotifications.repository;

import cu.edu.cujae.tykenotifications.domain.NotificationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface NotificationsRepository extends JpaRepository<NotificationsEntity, Long> {

    List<NotificationsEntity> findAllByIdUsuarioAndReadedIsFalse(long idUsuario);

    List<NotificationsEntity> findAllByIdUsuario(long idUsuario);

}
