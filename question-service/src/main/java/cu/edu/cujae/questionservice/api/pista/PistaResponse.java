package cu.edu.cujae.questionservice.api.pista;

import cu.edu.cujae.questionservice.api.pregunta.PreguntaResponseWithoutCollections;
import cu.edu.cujae.questionservice.api.tipoPista.TipoPistaResponse;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PistaResponse {
    private long id;
    private String textoAyuda;
    private TipoPistaResponse tipoPistaByIdTipoPista;
    private PreguntaResponseWithoutCollections preguntaByIdPregunta;
}
