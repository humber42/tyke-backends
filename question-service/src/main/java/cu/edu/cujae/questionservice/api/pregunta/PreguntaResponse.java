package cu.edu.cujae.questionservice.api.pregunta;

import cu.edu.cujae.questionservice.api.bonificacionPreguntaTiempo.BonificacionPreguntaTiempoResponseWithoutCollections;
import cu.edu.cujae.questionservice.api.feedback.FeedbackResponse;
import cu.edu.cujae.questionservice.api.feedback.FeedbackWithoutCollections;
import cu.edu.cujae.questionservice.api.pista.PistaResponseWithoutCollections;
import cu.edu.cujae.questionservice.api.profileRespuestaPregunta.ProfileRespuestaPreguntaResponse;
import cu.edu.cujae.questionservice.api.respuesta.RespuestaResponseWithoutCollections;
import cu.edu.cujae.questionservice.api.tipoPregunta.TipoPreguntaResponse;
import cu.edu.cujae.questionservice.dto.AsignaturaDto;
import lombok.*;

import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PreguntaResponse {
    private long id;
    private String tituloPregunta;
    private Integer tiempoEnSegundos;
    private Integer cantPuntosCompletarCorrectamente;
    private String asignatura;
    private Collection<BonificacionPreguntaTiempoResponseWithoutCollections> bonificacionPreguntaTiemposById;
    private Collection<FeedbackWithoutCollections> feedbacksById;
    private Collection<PistaResponseWithoutCollections> pistasById;
    private TipoPreguntaResponse tipoPreguntaByIdTipoPregunta;
    private Collection<ProfileRespuestaPreguntaResponse> profileRespuestaPreguntasById;
    private Collection<RespuestaResponseWithoutCollections> respuestasById;
    private AsignaturaDto asignaturaObject;
}
