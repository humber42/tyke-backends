package cu.edu.cujae.tykestrategy.api.models.jugador_estrategia;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JugadorEstrategiaRequest {
    private Long idJugador;
    private Integer puntuacionObtenida;
    private Boolean completada;
    private long idEstrategia;
}
