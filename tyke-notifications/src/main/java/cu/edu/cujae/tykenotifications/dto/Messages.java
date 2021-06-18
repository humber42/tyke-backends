package cu.edu.cujae.tykenotifications.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Messages {
    private long id;
    private String message;
    private Long idFromUser;
    private Long idToUser;
    private User fromUser;
    private User toUser;
    private Boolean received;
    private Boolean readed;
}
