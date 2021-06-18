package cu.edu.cujae.tykestrategy.api.models.jugador_desafio;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class JugadorDesafioRequest {
    //Usuarios
    private Long idJugadorDesafiante;
    private Long idJugadorDesafiado;

    //Valores de estado
    private Boolean desafioEntregado;
    private Boolean desafioConfirmado;

    private long idEstrategia;
}
