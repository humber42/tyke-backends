package cu.edu.cujae.scholarManagement.api.compositions.semestre_asignatura;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class SemestreAsignaturaRequest {
    private Integer idSemestre;
    private Integer idAsignatura;
}
