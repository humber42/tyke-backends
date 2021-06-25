package cu.edu.cujae.questionservice.api.respuesta;

import cu.edu.cujae.questionservice.api.pregunta.PreguntaResponseWithoutCollections;
import cu.edu.cujae.questionservice.api.profileRespuestaPregunta.ProfileRespuestaPreguntaResponse;
import lombok.*;

import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RespuestaResponse {
    private long id;
    private String texto;
    private Integer puntuacion;
    private Boolean correcta;
    private Integer orden;
    private String textoEnlazar;
    private Long idPregunta;
    private Collection<ProfileRespuestaPreguntaResponse> profileRespuestaPreguntasById;
    private PreguntaResponseWithoutCollections preguntaByIdPregunta;
}
