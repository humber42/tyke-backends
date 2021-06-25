package cu.edu.cujae.questionservice.api.pregunta;

import cu.edu.cujae.questionservice.api.tipoPregunta.TipoPreguntaResponse;
import cu.edu.cujae.questionservice.dto.AsignaturaDto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PreguntaResponseWithoutCollections {
    private long id;
    private String tituloPregunta;
    private Integer tiempoEnSegundos;
    private Integer cantPuntosCompletarCorrectamente;
    private String asignatura;
    private TipoPreguntaResponse tipoPreguntaByIdTipoPregunta;
    private AsignaturaDto asignaturaObject;

}
