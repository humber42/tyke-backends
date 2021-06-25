package cu.edu.cujae.questionservice.api.pista;

import cu.edu.cujae.questionservice.api.tipoPista.TipoPistaResponse;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@EqualsAndHashCode
public class PistaResponseWithoutCollections {
    private long id;
    private String textoAyuda;
    private TipoPistaResponse tipoPistaByIdTipoPista;

}
