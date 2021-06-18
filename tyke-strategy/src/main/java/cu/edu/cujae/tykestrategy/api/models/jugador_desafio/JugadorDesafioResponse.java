package cu.edu.cujae.tykestrategy.api.models.jugador_desafio;

import cu.edu.cujae.tykestrategy.api.models.estrategia.EstrategiaResponse;
import cu.edu.cujae.tykestrategy.api.models.estrategia.EstrategiaResponseWithoutCollection;
import cu.edu.cujae.tykestrategy.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JugadorDesafioResponse {
    private long idJugadorDesafio;
    //Usuarios
    private UserDto jugadorDesafiante;
    private UserDto jugadorDesafiado;
    //Valores de estado
    private Boolean desafioEntregado;
    private Boolean desafioConfirmado;
    private EstrategiaResponseWithoutCollection estrategia;

}
