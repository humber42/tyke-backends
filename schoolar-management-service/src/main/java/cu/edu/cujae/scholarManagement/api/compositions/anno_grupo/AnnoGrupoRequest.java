package cu.edu.cujae.scholarManagement.api.compositions.anno_grupo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class AnnoGrupoRequest {
    private Integer idAnno;
    private Integer idGrupo;
}
