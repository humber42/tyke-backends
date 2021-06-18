package cu.edu.cujae.questionservice.api.tipoPista;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoPistaRequest {
    private String tipo;
    private Integer puntosPista;
    private Integer puntosJuego;
}
