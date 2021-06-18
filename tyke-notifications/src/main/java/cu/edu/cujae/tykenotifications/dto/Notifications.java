package cu.edu.cujae.tykenotifications.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notifications {
    private long id;
    private String notification;
    private Long idUsuario;
    private User user;
    private Boolean readed;
}
