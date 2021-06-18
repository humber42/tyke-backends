package cu.edu.cujae.tykestrategy.api.models.puntuacion;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PuntuacionRequest {
    private Long idEstudiante;
    private Long puntuacion;
}
