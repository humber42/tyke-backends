package cu.edu.cujae.tykestrategy.api.models.jugador_regalo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JugadorRegaloRequest {
    private Long idJugador;
    private Integer cantidad;
    private long idRegalo;

}
