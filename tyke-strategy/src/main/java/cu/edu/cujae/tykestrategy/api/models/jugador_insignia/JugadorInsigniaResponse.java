package cu.edu.cujae.tykestrategy.api.models.jugador_insignia;

import cu.edu.cujae.tykestrategy.api.models.insignia.InsigniaResponse;
import cu.edu.cujae.tykestrategy.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class JugadorInsigniaResponse {
    private long idJugadorInsignias;
    private UserDto jugador;
    private Integer nivelAvance;

    private InsigniaResponse insignia;
}
