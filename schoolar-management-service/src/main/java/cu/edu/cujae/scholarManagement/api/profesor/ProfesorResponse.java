package cu.edu.cujae.scholarManagement.api.profesor;

import cu.edu.cujae.scholarManagement.api.compositions.asignatura_profesor_grupo.AsignaturaProfesorGrupoResponse;
import cu.edu.cujae.scholarManagement.api.facultad.FacultadResponseWithoutCarreer;
import cu.edu.cujae.scholarManagement.dto.UsuarioDto;
import lombok.*;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class ProfesorResponse {
    private Integer id;
    private String gradoCientifico;
    private String gradoDocente;
    private String telefono;
    private UsuarioDto usuario;
    private FacultadResponseWithoutCarreer facultadByIdFacultad;
    private Collection<AsignaturaProfesorGrupoResponse> asignaturaProfesorGruposById;
}
