package cu.edu.cujae.scholarManagement.api.asignatura;

import cu.edu.cujae.scholarManagement.api.compositions.asignatura_profesor_estudiante.AsignaturaProfesorEstudianteResponse;
import cu.edu.cujae.scholarManagement.api.compositions.asignatura_tema.AsignaturaTemaResponse;
import cu.edu.cujae.scholarManagement.api.compositions.semestre_asignatura.SemestreAsignaturaResponse;
import cu.edu.cujae.scholarManagement.api.compositions.signature_career.SignatureCareerResponse;
import lombok.*;

import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class AsignaturaResponse {

    private Integer id;
    private String nombre;
    private Boolean activo;
    private Collection<AsignaturaProfesorEstudianteResponse> asignaturaProfesorEstudiantesById;
    private Collection<AsignaturaTemaResponse> asignaturaTemasById;
    private Collection<SemestreAsignaturaResponse> semestreAsignaturasById;
    private Collection<SignatureCareerResponse> signatureCarreraById;
}
