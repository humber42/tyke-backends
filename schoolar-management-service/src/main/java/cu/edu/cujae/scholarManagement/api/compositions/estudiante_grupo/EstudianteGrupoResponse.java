package cu.edu.cujae.scholarManagement.api.compositions.estudiante_grupo;

import cu.edu.cujae.scholarManagement.api.anno.AnnoResponseWithoutCollections;
import cu.edu.cujae.scholarManagement.api.curso.CursoResponseWithoutCollections;
import cu.edu.cujae.scholarManagement.api.estudiante.EstudianteResponseWithoutCollection;
import cu.edu.cujae.scholarManagement.api.grupo.GrupoResponseWithoutCollections;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class EstudianteGrupoResponse {
    private EstudianteResponseWithoutCollection estudianteByIdEstudiante;
    private GrupoResponseWithoutCollections grupoByIdGrupo;
    private CursoResponseWithoutCollections cursoByIdCurso;
    private AnnoResponseWithoutCollections annoByIdAnno;
}
