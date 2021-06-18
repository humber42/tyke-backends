package cu.edu.cujae.tykenotifications.api.notifications;

import cu.edu.cujae.tykenotifications.dto.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationsResponse {
    private long id;
    private String notification;
    private User user;
    private Boolean readed;
}
