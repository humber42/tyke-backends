package cu.edu.cujae.questionservice.api.pista;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PistaRequest {

    private String textoAyuda;
    private long idTipoPista;
}
