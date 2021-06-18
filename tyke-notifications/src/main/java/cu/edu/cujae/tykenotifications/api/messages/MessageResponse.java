package cu.edu.cujae.tykenotifications.api.messages;

import cu.edu.cujae.tykenotifications.dto.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageResponse {
    private long id;
    private String message;
    private User fromUser;
    private User toUser;
    private Boolean received;
    private Boolean readed;
}
