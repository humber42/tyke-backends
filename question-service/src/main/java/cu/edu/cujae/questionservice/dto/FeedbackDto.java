package cu.edu.cujae.questionservice.dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class FeedbackDto {
    private Long id;
    private String username;
    private String feedback;
    private long idPregunta;
    private PreguntaDto preguntaByIdPregunta;
    private UserDto user;
}
