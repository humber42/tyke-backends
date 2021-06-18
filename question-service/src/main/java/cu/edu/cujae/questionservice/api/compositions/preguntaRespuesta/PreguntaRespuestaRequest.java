package cu.edu.cujae.questionservice.api.compositions.preguntaRespuesta;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PreguntaRespuestaRequest {
    private boolean correcta;
    private int id_pregunta;
    private int id_respuesta;
    private long pregunta_padre;
    private int orden;
}
