package cu.edu.cujae.questionservice.api.respuesta;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RespuestaRequestToPregunta {
    private String respuesta;
    private boolean correcta;
    private int orden;
    private String pregunta;
    private String fraseFinal;
    private int puntuacion;
}
