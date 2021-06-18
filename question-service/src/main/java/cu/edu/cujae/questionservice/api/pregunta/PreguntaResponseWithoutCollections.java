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
    private Long id;
    private String tituloPregunta;
    private AsignaturaDto asignaturaObject;
    private Integer tiempoEnSegundos;
    private Integer cantPuntosCompletarCorrectamente;
    private TipoPreguntaResponse tipoPreguntaByIdTipoPregunta;

}
