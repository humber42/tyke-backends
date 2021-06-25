package cu.edu.cujae.questionservice.api.profileRespuestaPregunta;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileRespuestaPreguntaRequest {
    private Long idRespuesta;
    private Long idPregunta;
    private Integer tiempoSegundos;
    private String username;
}
