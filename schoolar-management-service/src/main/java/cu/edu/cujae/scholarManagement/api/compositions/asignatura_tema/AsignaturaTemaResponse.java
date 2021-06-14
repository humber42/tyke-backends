package cu.edu.cujae.scholarManagement.api.compositions.asignatura_tema;

import cu.edu.cujae.scholarManagement.api.asignatura.AsignaturaResponseWithoutCollections;
import cu.edu.cujae.scholarManagement.api.tema.TemaResponseWithoutCollections;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class AsignaturaTemaResponse {
    private AsignaturaResponseWithoutCollections asignaturaByIdAsignatura;
    private TemaResponseWithoutCollections temaByIdTema;
}
