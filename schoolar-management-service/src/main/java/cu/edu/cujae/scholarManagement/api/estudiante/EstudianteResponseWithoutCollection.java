package cu.edu.cujae.scholarManagement.api.estudiante;

import cu.edu.cujae.scholarManagement.api.facultad.FacultadResponseWithoutCarreer;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class EstudianteResponseWithoutCollection {
    private Integer id;
    private int idUsuario;
    private FacultadResponseWithoutCarreer facultadByIdFacultad;
}
