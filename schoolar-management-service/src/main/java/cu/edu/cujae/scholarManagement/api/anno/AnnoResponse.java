package cu.edu.cujae.scholarManagement.api.anno;

import cu.edu.cujae.scholarManagement.api.compositions.anno_grupo.AnnoGrupoResponse;
import cu.edu.cujae.scholarManagement.api.compositions.anno_semestre.AnnoSemestreResponse;
import cu.edu.cujae.scholarManagement.api.compositions.curso_anno.CursoAnnoResponse;
import cu.edu.cujae.scholarManagement.api.compositions.estudiante_grupo.EstudianteGrupoResponse;
import lombok.*;

import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class AnnoResponse {
    private Integer id;
    private String anno;
    private Collection<AnnoGrupoResponse> annoGruposById;
    private Collection<AnnoSemestreResponse> annoSemestresById;
    private Collection<CursoAnnoResponse> cursoAnnosById;
    private Collection<EstudianteGrupoResponse> estudianteGruposById;
}
