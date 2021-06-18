package cu.edu.cujae.tykenotifications.service;

import cu.edu.cujae.tykenotifications.dto.Messages;

import java.util.List;
import java.util.Optional;

public interface MessageService {

    List<Messages> getAllMessageMyMessage(long idUser);

    List<Messages> getAllMessageFromUserToUser(long idFromUser, long idtoUser);

    List<Messages> getAllMessageFromUser(long idUser);

    List<Messages> getAllMessageNotReceived(long idUser);

    Optional<Messages> getMessageById(long id);

    void deletMessageById(long id);

    void deleteMessageJustForMe(long id, boolean receiver);

    Messages saveMessage(Messages messages);

    Messages markAsReceived(long id);

    Messages markAsRead(long id);
}
