package cu.edu.cujae.questionservice.api.pista;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PistaRequest {
    private long id;
    private String textoAyuda;
    private int idTipoPista;
    private Long idPregunta;
}
