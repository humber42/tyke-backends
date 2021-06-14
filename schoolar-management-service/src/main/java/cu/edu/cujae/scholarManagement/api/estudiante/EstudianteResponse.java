package cu.edu.cujae.scholarManagement.api.estudiante;

import cu.edu.cujae.scholarManagement.api.compositions.asignatura_profesor_estudiante.AsignaturaProfesorEstudianteResponse;
import cu.edu.cujae.scholarManagement.api.compositions.estudiante_grupo.EstudianteGrupoResponse;
import cu.edu.cujae.scholarManagement.api.facultad.FacultadResponseWithoutCarreer;
import cu.edu.cujae.scholarManagement.dto.EstudianteGrupoDto;
import cu.edu.cujae.scholarManagement.dto.UsuarioDto;
import lombok.*;

import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class EstudianteResponse {

    private Integer id;
    private UsuarioDto usuario;
    private Collection<AsignaturaProfesorEstudianteResponse> asignaturaProfesorEstudiantesById;
    //TODO:Cambiar clases
    private Collection<EstudianteGrupoResponse> estudianteGruposById;
    private int id_facultad;
    private FacultadResponseWithoutCarreer facultadByIdFacultad;
}
