package cu.edu.cujae.tykenotifications.service;

import cu.edu.cujae.tykenotifications.dto.Notifications;

import java.util.List;

public interface NotificationService {

    List<Notifications> findAllNewNotificationsToMe(long idUser);

    List<Notifications> findAllMyNotifications(long idUser);

    Notifications markAsRead(long id);

    Notifications newNotifications(Notifications notifications);

    void deleteNotification(long id);
}
