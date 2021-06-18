package cu.edu.cujae.tykestrategy.dto;


import cu.edu.cujae.tykestrategy.domain.EstrategiaEntity;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class JugadorDesafioDto {
    private long idJugadorDesafio;

    //Usuarios
    private Long idJugadorDesafiante;
    private UserDto jugadorDesafiante;
    private Long idJugadorDesafiado;
    private UserDto jugadorDesafiado;

    //Valores de estado
    private Boolean desafioEntregado;
    private Boolean desafioConfirmado;

    private EstrategiaDto estrategia;
    private long idEstrategia;
}
