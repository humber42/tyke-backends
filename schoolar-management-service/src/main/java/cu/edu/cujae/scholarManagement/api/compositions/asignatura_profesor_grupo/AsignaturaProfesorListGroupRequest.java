package cu.edu.cujae.scholarManagement.api.compositions.asignatura_profesor_grupo;

import cu.edu.cujae.scholarManagement.api.grupo.GrupoResponse;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AsignaturaProfesorListGroupRequest {
    private List<GrupoResponse> gruposList;
    private String asingnatura;
    private int idProfesor;
}
