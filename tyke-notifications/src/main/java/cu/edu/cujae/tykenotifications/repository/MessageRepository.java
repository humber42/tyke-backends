package cu.edu.cujae.tykenotifications.repository;

import cu.edu.cujae.tykenotifications.domain.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<MessageEntity, Long> {

    List<MessageEntity> findAllByIdFromUser(long idFromUser);

    List<MessageEntity> findAllByIdFromUserAndIdToUser(long idFromUser, long idToUser);

    List<MessageEntity> findAllByIdToUserAndReceivedIsFalse(long idToUser);

    List<MessageEntity> findAllByIdToUser(long idToUser);


}
