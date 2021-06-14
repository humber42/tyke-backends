package cu.edu.cujae.scholarManagement.api.compositions.facultad_curso;

import cu.edu.cujae.scholarManagement.api.curso.CursoResponseWithoutCollections;
import cu.edu.cujae.scholarManagement.api.facultad.FacultadResponseWithoutCarreer;
import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class FacultadCursoResponse {
    private FacultadResponseWithoutCarreer facultadByIdFacultad;
    private CursoResponseWithoutCollections cursoByIdCurso;
}
