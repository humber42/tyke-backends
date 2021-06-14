package cu.edu.cujae.scholarManagement.api.compositions.estudiante_grupo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class EstudianteGrupoRequest {
    private Integer idEstudiante;
    private Integer idGrupo;
    private Integer idCurso;
    private Integer idAnno;
}
