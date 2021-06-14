package cu.edu.cujae.scholarManagement.api.compositions.anno_grupo;

import cu.edu.cujae.scholarManagement.api.anno.AnnoResponseWithoutCollections;
import cu.edu.cujae.scholarManagement.api.grupo.GrupoResponseWithoutCollections;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class AnnoGrupoResponse {
    private AnnoResponseWithoutCollections annoByIdAnno;
    private GrupoResponseWithoutCollections grupoByIdGrupo;
}
