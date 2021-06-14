package cu.edu.cujae.scholarManagement.api.compositions.curso_anno;

import cu.edu.cujae.scholarManagement.api.anno.AnnoResponseWithoutCollections;
import cu.edu.cujae.scholarManagement.api.curso.CursoResponseWithoutCollections;
import lombok.*;


@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CursoAnnoResponse {
    private CursoResponseWithoutCollections cursoByIdCurso;
    private AnnoResponseWithoutCollections annoByIdAnno;
}
