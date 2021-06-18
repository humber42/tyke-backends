package cu.edu.cujae.tykestrategy.api.models.puntuacion;

import cu.edu.cujae.tykestrategy.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PuntuacionResponse {
    private long idPuntuacion;
    private Long puntuacion;
    private UserDto usuario;
}
