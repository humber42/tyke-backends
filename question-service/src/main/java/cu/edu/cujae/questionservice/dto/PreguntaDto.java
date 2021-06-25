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
    private long id;
    private String tituloPregunta;
    private Long idTipoPregunta;
    private Integer tiempoEnSegundos;
    private Integer cantPuntosCompletarCorrectamente;
    private String asignatura;
    private Collection<BonificacionPreguntaTiempoDto> bonificacionPreguntaTiemposById;
    private Collection<FeedbackDto> feedbacksById;
    private Collection<PistaDto> pistasById;
    private TipoPreguntaDto tipoPreguntaByIdTipoPregunta;
    private Collection<ProfileRespuestaPreguntaDto> profileRespuestaPreguntasById;
    private Collection<RespuestaDto> respuestasById;
    private AsignaturaDto asignaturaObject;
}
