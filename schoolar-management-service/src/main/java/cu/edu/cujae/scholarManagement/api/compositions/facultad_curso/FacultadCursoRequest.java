package cu.edu.cujae.scholarManagement.api.compositions.facultad_curso;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class FacultadCursoRequest {
    private Integer idFacultad;
    private Integer idCurso;
}
