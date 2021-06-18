package cu.edu.cujae.tykestrategy.dto;


import lombok.*;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class JugadorEstrategiaDto {
    private long idJugadorEstrategia;
    private Long idJugador;
    private UserDto jugador;
    private Integer puntuacionObtenida;
    private Boolean completada;
    private long idEstrategia;


    //private EstrategiaEntity estrategia;
}
