package cu.edu.cujae.questionservice.api.pregunta;

import cu.edu.cujae.questionservice.api.bonificacionPreguntaTiempo.BonificacionPreguntaTiempoRequest;
import cu.edu.cujae.questionservice.api.pista.PistaRequestForQuestion;
import cu.edu.cujae.questionservice.api.respuesta.RespuestaRequestToPregunta;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@Setter
@Getter
@Builder
@NoArgsConstructor
public class PreguntaRequestWithRespuestasCluesBonifications {
    private String tituloPregunta;
    private int tiempoMenor;
    private String tipoPregunta;
    private String asignatura;
    private int puntuacion;
    private List<RespuestaRequestToPregunta> respuestas;
    private List<BonificacionPreguntaTiempoRequest> bonificaciones;
    private List<PistaRequestForQuestion> pistas;
}
