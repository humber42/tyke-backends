package cu.edu.cujae.questionservice.api.profileRespuestaPregunta;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileRespuestaPreguntaRequest {

    private String username;
    private Integer tiempoSegundos;
    private long idRespuesta;
    private long idPregunta;

}
