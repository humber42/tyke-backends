package cu.edu.cujae.tykestrategy.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class JugadorRegaloDto {

    private long idJugadorRegalos;

    private UserDto jugador;
    private Long idJugador;


    private Integer cantidad;

    private long idRegalo;
    private RegaloDto regalo;

}
