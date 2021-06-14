package cu.edu.cujae.scholarManagement.api.compositions.curso_anno;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class CursoAnnoRequest {
    private Integer idCurso;
    private Integer idAnno;
}
