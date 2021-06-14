package cu.edu.cujae.scholarManagement.api.compositions.semestre_asignatura;

import cu.edu.cujae.scholarManagement.api.asignatura.AsignaturaResponseWithoutCollections;
import cu.edu.cujae.scholarManagement.api.semestre.SemestreResponseWithoutCollection;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class SemestreAsignaturaResponse {
    private SemestreResponseWithoutCollection semestreByIdSemestre;
    private AsignaturaResponseWithoutCollections asignaturaByIdAsignatura;
}
