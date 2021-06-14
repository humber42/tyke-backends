package cu.edu.cujae.scholarManagement.api.compositions.asignatura_profesor_estudiante;

import cu.edu.cujae.scholarManagement.api.asignatura.AsignaturaResponseWithoutCollections;
import cu.edu.cujae.scholarManagement.api.estudiante.EstudianteResponseWithoutCollection;

import cu.edu.cujae.scholarManagement.api.profesor.ProfesorResponseWithoutCollections;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
public class AsignaturaProfesorEstudianteResponse {
    private AsignaturaResponseWithoutCollections asignaturaByIdAsignatura;
    private ProfesorResponseWithoutCollections profesorByIdProfesor;
    private EstudianteResponseWithoutCollection estudianteByIdEstudiante;

}
