package cu.edu.cujae.tykenotifications.api.messages;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageRequest {
    private String message;
    private Long idFromUser;
    private Long idToUser;
    private Boolean received;
    private Boolean readed;
}
