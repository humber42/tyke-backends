package cu.edu.cujae.tykestrategy.api.models.rol_profesional;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RolProfesionalRequest {
    private Long idCarrera;
    private Long idTema;
    private String nombre;
}
