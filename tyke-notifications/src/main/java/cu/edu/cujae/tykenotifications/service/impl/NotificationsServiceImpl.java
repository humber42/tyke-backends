package cu.edu.cujae.tykenotifications.service.impl;

import cu.edu.cujae.tykenotifications.domain.NotificationsEntity;
import cu.edu.cujae.tykenotifications.dto.Notifications;
import cu.edu.cujae.tykenotifications.dto.User;
import cu.edu.cujae.tykenotifications.feing_interface.UserInterface;
import cu.edu.cujae.tykenotifications.repository.NotificationsRepository;
import cu.edu.cujae.tykenotifications.service.NotificationService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class NotificationsServiceImpl implements NotificationService {

    @Autowired
    private NotificationsRepository repository;
    @Autowired
    private Mapper mapper;
    @Autowired
    private UserInterface userService;


    @Override
    public List<Notifications> findAllMyNotifications(long idUser) {
        return repository.findAllByIdUsuario(idUser)
                .stream()
                .map(this::mappingNotification)
                .collect(Collectors.toList());
    }

    @Override
    public List<Notifications> findAllNewNotificationsToMe(long idUser) {
        return repository.findAllByIdUsuarioAndReadedIsFalse(idUser)
                .stream()
                .map(this::mappingNotification)
                .collect(Collectors.toList());
    }

    @Override
    public Notifications newNotifications(Notifications notifications) {
        return mappingNotification(
                repository.save(
                        mapper.map(notifications, NotificationsEntity.class)
                ));
    }

    @Override
    public Notifications markAsRead(long id) {
        Notifications notifications = repository.findById(id).map(this::mappingNotification).get();
        notifications.setReaded(true);
        repository.saveAndFlush(mapper.map(notifications, NotificationsEntity.class));
        return notifications;

    }

    @Override
    public void deleteNotification(long id) {
        repository.deleteById(id);
    }

    private Notifications mappingNotification(NotificationsEntity entity) {
        Notifications notification = mapper.map(entity, Notifications.class);
        User user = userService.searchById(notification.getIdUsuario());
        notification.setUser(user);
        return notification;
    }
}
