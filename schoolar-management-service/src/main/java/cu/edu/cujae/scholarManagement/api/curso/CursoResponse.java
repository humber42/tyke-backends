package cu.edu.cujae.scholarManagement.api.curso;

import cu.edu.cujae.scholarManagement.api.compositions.curso_anno.CursoAnnoResponse;
import cu.edu.cujae.scholarManagement.api.compositions.estudiante_grupo.EstudianteGrupoResponse;
import cu.edu.cujae.scholarManagement.api.compositions.facultad_curso.FacultadCursoResponse;
import lombok.*;

import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class CursoResponse {
    private Integer id;
    private String curso;
    private Boolean activo;
    private Collection<CursoAnnoResponse> cursoAnnosById;
    private Collection<EstudianteGrupoResponse> estudianteGruposById;
    private Collection<FacultadCursoResponse> facultadCursosById;
}
