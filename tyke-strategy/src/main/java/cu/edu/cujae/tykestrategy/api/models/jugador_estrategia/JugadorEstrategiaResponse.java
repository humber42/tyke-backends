package cu.edu.cujae.tykestrategy.api.models.jugador_estrategia;

import cu.edu.cujae.tykestrategy.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JugadorEstrategiaResponse {
    private long idJugadorEstrategia;
    private UserDto jugador;
    private Integer puntuacionObtenida;
    private Boolean completada;

}
