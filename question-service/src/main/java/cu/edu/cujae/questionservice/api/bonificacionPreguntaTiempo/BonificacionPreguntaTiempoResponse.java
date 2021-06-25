package cu.edu.cujae.questionservice.api.bonificacionPreguntaTiempo;

import cu.edu.cujae.questionservice.api.pregunta.PreguntaResponseWithoutCollections;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BonificacionPreguntaTiempoResponse {
    private long id;
    private Long idPregunta;
    private Long tiempoMenor;
    private Integer bonificacion;
    private PreguntaResponseWithoutCollections preguntaByIdPregunta;
}
