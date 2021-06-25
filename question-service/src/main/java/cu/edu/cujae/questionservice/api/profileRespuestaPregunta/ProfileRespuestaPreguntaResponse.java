package cu.edu.cujae.questionservice.api.profileRespuestaPregunta;

import cu.edu.cujae.questionservice.api.pregunta.PreguntaResponseWithoutCollections;
import cu.edu.cujae.questionservice.api.respuesta.RespuestaResponseWithoutCollections;
import cu.edu.cujae.questionservice.dto.UserDto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileRespuestaPreguntaResponse {
    private long id;
    private Integer tiempoSegundos;
    private String username;
    private RespuestaResponseWithoutCollections respuestaByIdRespuesta;
    private PreguntaResponseWithoutCollections preguntaByIdPregunta;
    private UserDto userDto;
}
