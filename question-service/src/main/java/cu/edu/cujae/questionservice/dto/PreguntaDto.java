package cu.edu.cujae.questionservice.dto;


import lombok.*;

import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class PreguntaDto {
    private Long id;
    private String tituloPregunta;
    private long idTipoPregunta;
    private AsignaturaDto asignaturaObject;
    private String asignatura;
    private Integer tiempoEnSegundos;
    private Integer cantPuntosCompletarCorrectamente;
    private Collection<BonificacionPreguntaTiempoDto> bonificacionPreguntaTiemposById;
    private Collection<FeedbackDto> feedbacksById;
    private Collection<PistaPreguntaDto> pistaPreguntasById;
    private TipoPreguntaDto tipoPreguntaByIdTipoPregunta;
    private Collection<PreguntaRespuestaDto> preguntaRespuestasById;
}
