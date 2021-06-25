package cu.edu.cujae.questionservice.api.feedback;

import cu.edu.cujae.questionservice.api.pregunta.PreguntaResponseWithoutCollections;
import cu.edu.cujae.questionservice.dto.UserDto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class FeedbackResponse {
    private long id;
    private String feedback;
    private Long idPregunta;
    private PreguntaResponseWithoutCollections preguntaByIdPregunta;
    private UserDto user;
}
