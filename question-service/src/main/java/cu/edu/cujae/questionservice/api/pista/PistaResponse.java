package cu.edu.cujae.questionservice.api.pista;

import cu.edu.cujae.questionservice.api.tipoPista.TipoPistaResponse;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PistaResponse {
    private Long id;
    private String textoAyuda;
    private TipoPistaResponse tipoPistaByIdTipoPista;
}
