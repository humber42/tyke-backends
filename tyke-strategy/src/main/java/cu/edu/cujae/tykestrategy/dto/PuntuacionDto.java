package cu.edu.cujae.tykestrategy.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class PuntuacionDto {
    private long idPuntuacion;
    private Long idEstudiante;
    private Long puntuacion;
    private UserDto usuario;
}
