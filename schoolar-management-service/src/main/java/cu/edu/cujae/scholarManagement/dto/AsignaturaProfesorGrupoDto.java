package cu.edu.cujae.scholarManagement.dto;

import lombok.*;
import java.util.Objects;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class AsignaturaProfesorGrupoDto {
    private Integer idAsignatura;
    private Integer idProfesor;
    private Integer idGrupo;
    private AsignaturaDto asignaturaByIdAsignatura;
    private ProfesorDto profesorByIdProfesor;
    private GrupoDto grupoByIdGrupo;






}
