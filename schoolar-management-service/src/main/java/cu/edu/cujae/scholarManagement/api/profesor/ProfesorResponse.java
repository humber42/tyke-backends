package cu.edu.cujae.scholarManagement.api.profesor;

import cu.edu.cujae.scholarManagement.api.compositions.asignatura_profesor_estudiante.AsignaturaProfesorEstudianteResponse;
import cu.edu.cujae.scholarManagement.api.facultad.FacultadResponseWithoutCarreer;
import cu.edu.cujae.scholarManagement.dto.AsignaturaProfesorEstudianteDto;
import cu.edu.cujae.scholarManagement.dto.FacultadDto;
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
    private String nombre;
    private String apellidos;
    private String gradoCientifico;
    private String gradoDocente;
    private String telefono;
    private String correo;
    private Boolean permiso;
    private UsuarioDto usuario;
    private FacultadResponseWithoutCarreer facultadByIdFacultad;
    private Collection<AsignaturaProfesorEstudianteResponse> asignaturaProfesorEstudiantesById;
}
