package cu.edu.cujae.tykenotifications.api.notifications;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationsRequest {
    private String notification;
    private Long idUsuario;
    private Boolean readed;
}
