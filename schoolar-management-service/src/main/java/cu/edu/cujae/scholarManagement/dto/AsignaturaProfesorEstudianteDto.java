package cu.edu.cujae.scholarManagement.dto;

import lombok.*;
import java.util.Objects;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class AsignaturaProfesorEstudianteDto {
    private Integer idAsignatura;
    private Integer idProfesor;
    private Integer idEstudiante;
    private AsignaturaDto asignaturaByIdAsignatura;
    private ProfesorDto profesorByIdProfesor;
    private EstudianteDto estudianteByIdEstudiante;






}
