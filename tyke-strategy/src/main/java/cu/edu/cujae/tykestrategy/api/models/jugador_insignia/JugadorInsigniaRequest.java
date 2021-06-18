package cu.edu.cujae.tykestrategy.api.models.jugador_insignia;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JugadorInsigniaRequest {

    private Long idJugador;
    private Integer nivelAvance;
    private long idInsignia;

}
