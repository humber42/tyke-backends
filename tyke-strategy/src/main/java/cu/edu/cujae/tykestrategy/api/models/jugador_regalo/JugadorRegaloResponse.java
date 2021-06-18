package cu.edu.cujae.tykestrategy.api.models.jugador_regalo;

import cu.edu.cujae.tykestrategy.api.models.regalo.RegaloResponse;
import cu.edu.cujae.tykestrategy.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JugadorRegaloResponse {
    private long idJugadorRegalos;
    private UserDto jugador;
    private Integer cantidad;

    private RegaloResponse regalo;
}
