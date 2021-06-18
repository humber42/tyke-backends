package cu.edu.cujae.questionservice.api.feedback;


import cu.edu.cujae.questionservice.dto.UserDto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class FeedbackWithoutCollections {
    private Long id;
    private UserDto user;
    private String feedback;
}
