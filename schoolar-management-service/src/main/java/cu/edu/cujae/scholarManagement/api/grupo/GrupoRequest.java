package cu.edu.cujae.scholarManagement.api.grupo;

import cu.edu.cujae.scholarManagement.api.estudiante.EstudianteResponse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class GrupoRequest {
    private String grupo;
    private List<EstudianteResponse> estudiantes;
    private String curso;
    private int anno;
    private String carrera;
}
