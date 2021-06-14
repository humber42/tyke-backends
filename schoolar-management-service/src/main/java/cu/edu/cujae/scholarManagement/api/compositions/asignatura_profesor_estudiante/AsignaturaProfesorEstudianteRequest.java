package cu.edu.cujae.scholarManagement.api.compositions.asignatura_profesor_estudiante;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class AsignaturaProfesorEstudianteRequest {
    private Integer idAsignatura;
    private Integer idProfesor;
    private Integer idEstudiante;
}
