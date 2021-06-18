package cu.edu.cujae.tykenotifications.api.notifications;

import cu.edu.cujae.tykenotifications.constants.WebResourceKeyConstants;
import cu.edu.cujae.tykenotifications.dto.Notifications;
import cu.edu.cujae.tykenotifications.service.NotificationService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(WebResourceKeyConstants.BASE_API_NOTIFICATIONS)
public class NotificationsRestController {

    @Autowired
    private NotificationService service;
    @Autowired
    private Mapper mapper;

    @GetMapping(WebResourceKeyConstants.NotificationsUrls.FIND_ALL_MY_NEW_NOTIFICATIONS)
    public List<NotificationsResponse> getAllMyNewNotifications(@PathVariable("id") long id) {
        return service.findAllNewNotificationsToMe(id)
                .stream()
                .map(this::mapping)
                .collect(Collectors.toList());
    }

    @GetMapping(WebResourceKeyConstants.NotificationsUrls.FIND_ALL_MY_NOTIFICATIONS)
    public List<NotificationsResponse> getAllMyNotifications(@PathVariable("id") long id) {
        return service.findAllMyNotifications(id)
                .stream()
                .map(this::mapping)
                .collect(Collectors.toList());
    }

    @PutMapping(WebResourceKeyConstants.NotificationsUrls.MARK_AS_READ)
    public NotificationsResponse markAsRead(@PathVariable("id") long id) {
        return mapping(service.markAsRead(id));
    }

    @PostMapping(WebResourceKeyConstants.NotificationsUrls.NEW_NOTIFICATIONS)
    public NotificationsResponse sendNotification(@RequestBody NotificationsRequest request) {
        return mapping(
                service.newNotifications(
                        mapper.map(request, Notifications.class))
        );
    }

    @DeleteMapping(WebResourceKeyConstants.NotificationsUrls.DELETE_NOTIFICATION)
    public void deleteNotification(@PathVariable("id") long id) {
        service.deleteNotification(id);
    }


    private NotificationsResponse mapping(Notifications notify) {
        return mapper.map(notify, NotificationsResponse.class);
    }
}
