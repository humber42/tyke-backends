package cu.edu.cujae.scholarManagement.api.compositions.asignatura_profesor_grupo;

import cu.edu.cujae.scholarManagement.api.asignatura.AsignaturaResponseWithoutCollections;
import cu.edu.cujae.scholarManagement.api.estudiante.EstudianteResponseWithoutCollection;

import cu.edu.cujae.scholarManagement.api.grupo.GrupoResponseWithoutCollections;
import cu.edu.cujae.scholarManagement.api.profesor.ProfesorResponseWithoutCollections;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
public class AsignaturaProfesorGrupoResponse {
    private AsignaturaResponseWithoutCollections asignaturaByIdAsignatura;
    private ProfesorResponseWithoutCollections profesorByIdProfesor;
    private GrupoResponseWithoutCollections grupoByIdGrupo;

}
