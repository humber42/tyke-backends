package cu.edu.cujae.scholarManagement.api.grupo;

import cu.edu.cujae.scholarManagement.api.carrera.CarreraResponse;
import cu.edu.cujae.scholarManagement.api.compositions.anno_grupo.AnnoGrupoResponse;
import cu.edu.cujae.scholarManagement.api.compositions.asignatura_profesor_grupo.AsignaturaProfesorGrupoResponse;
import cu.edu.cujae.scholarManagement.api.compositions.estudiante_grupo.EstudianteGrupoResponse;
import cu.edu.cujae.scholarManagement.dto.AnnoGrupoDto;
import cu.edu.cujae.scholarManagement.dto.EstudianteGrupoDto;
import lombok.*;

import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class GrupoResponse {

    private Long id;
    private String grupo;
    private Integer idCarrera;
    private CarreraResponse carreraByIdCarrera;
    private Collection<AnnoGrupoResponse> annoGruposById;
    private Collection<EstudianteGrupoResponse> estudianteGruposById;
    private Collection<AsignaturaProfesorGrupoResponse> asignaturaProfesorGruposById;
}
