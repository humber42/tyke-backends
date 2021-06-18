package cu.edu.cujae.scholarManagement.api.compositions.asignatura_profesor_grupo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class AsignaturaProfesorGrupoRequest {
    private Integer idAsignatura;
    private Integer idProfesor;
    private Integer idGrupo;
}
