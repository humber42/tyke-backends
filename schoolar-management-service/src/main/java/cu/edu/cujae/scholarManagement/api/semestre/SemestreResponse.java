package cu.edu.cujae.scholarManagement.api.semestre;

import cu.edu.cujae.scholarManagement.api.compositions.anno_semestre.AnnoSemestreResponse;
import cu.edu.cujae.scholarManagement.api.compositions.semestre_asignatura.SemestreAsignaturaResponse;
import cu.edu.cujae.scholarManagement.dto.AnnoSemestreDto;
import cu.edu.cujae.scholarManagement.dto.SemestreAsignaturaDto;
import lombok.*;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class SemestreResponse {

    private Integer id;
    private String semestre;
    private Integer activo;

    private Collection<AnnoSemestreResponse> annoSemestresById;
    private Collection<SemestreAsignaturaResponse> semestreAsignaturasById;
}
