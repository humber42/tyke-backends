package cu.edu.cujae.questionservice.api.pregunta;

import cu.edu.cujae.questionservice.api.bonificacionPreguntaTiempo.BonificacionPreguntaTiempoResponseWithoutCollections;
import cu.edu.cujae.questionservice.api.compositions.pistaPregunta.PistaPreguntaResponse;
import cu.edu.cujae.questionservice.api.compositions.preguntaRespuesta.PreguntaRespuestaResponse;
import cu.edu.cujae.questionservice.api.feedback.FeedbackWithoutCollections;
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
    private Long id;
    private String tituloPregunta;
    private AsignaturaDto asignaturaObject;
    private Integer tiempoEnSegundos;
    private Integer cantPuntosCompletarCorrectamente;
    private Collection<BonificacionPreguntaTiempoResponseWithoutCollections> bonificacionPreguntaTiemposById;
    private Collection<FeedbackWithoutCollections> feedbacksById;
    private Collection<PistaPreguntaResponse> pistaPreguntasById;
    private TipoPreguntaResponse tipoPreguntaByIdTipoPregunta;
    private Collection<PreguntaRespuestaResponse> preguntaRespuestasById;
}
