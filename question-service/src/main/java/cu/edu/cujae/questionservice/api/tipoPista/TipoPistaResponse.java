package cu.edu.cujae.questionservice.api.tipoPista;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TipoPistaResponse {
    private long id;
    private String tipo;
    private Integer puntosPista;
    private Integer puntosJuego;
}
