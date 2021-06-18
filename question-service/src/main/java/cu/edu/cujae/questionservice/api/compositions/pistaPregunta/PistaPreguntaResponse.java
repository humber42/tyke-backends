package cu.edu.cujae.questionservice.api.compositions.pistaPregunta;

import cu.edu.cujae.questionservice.api.pista.PistaResponse;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PistaPreguntaResponse {
    private PistaResponse pistaByIdPista;
}
