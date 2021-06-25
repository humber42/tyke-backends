package cu.edu.cujae.questionservice.dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class FeedbackDto {
    private long id;
    private String feedback;
    private Long idPregunta;
    private String username;
    private PreguntaDto preguntaByIdPregunta;
    private UserDto user;
}
