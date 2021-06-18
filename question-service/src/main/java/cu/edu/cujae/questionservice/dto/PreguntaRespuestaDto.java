package cu.edu.cujae.questionservice.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class PreguntaRespuestaDto {
    private Long id;
    private PreguntaDto preguntaByIdPregunta;
    private RespuestaDto respuestaByIdRespuesta;
    private PreguntaDto preguntaByPreguntaPadre;
    private long id_pregunta;
    private long id_respuesta;
    private long pregunta_padre;
    private int orden;
    private boolean correcta;
}
