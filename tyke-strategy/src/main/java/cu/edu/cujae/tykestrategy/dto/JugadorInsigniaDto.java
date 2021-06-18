package cu.edu.cujae.tykestrategy.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class JugadorInsigniaDto {

    private long idJugadorInsignias;
    private Long idJugador;
    private UserDto jugador;

    private Integer nivelAvance;
    private long idInsignia;
    private InsigniaDto insignia;

}
