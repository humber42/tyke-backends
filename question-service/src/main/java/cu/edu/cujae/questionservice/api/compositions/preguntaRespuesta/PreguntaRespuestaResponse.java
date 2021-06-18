package cu.edu.cujae.questionservice.api.compositions.preguntaRespuesta;

import cu.edu.cujae.questionservice.api.pregunta.PreguntaResponseWithoutCollections;
import cu.edu.cujae.questionservice.api.respuesta.RespuestaResponse;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PreguntaRespuestaResponse {
    private boolean correcta;
    private int orden;
    private PreguntaResponseWithoutCollections preguntaByIdPregunta;
    private RespuestaResponse respuestaByIdRespuesta;
    private PreguntaResponseWithoutCollections preguntaByPreguntaPadre;
}
