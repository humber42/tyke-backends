package cu.edu.cujae.scholarManagement.api.profesor;

import cu.edu.cujae.scholarManagement.api.facultad.FacultadResponseWithoutCarreer;
import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProfesorResponseWithoutCollections {
    private Integer id;
    private String nombre;
    private String apellidos;
    private String gradoCientifico;
    private String gradoDocente;
    private String telefono;
    private String correo;
    private Boolean permiso;
    private int id_usuario;
    private FacultadResponseWithoutCarreer facultadByIdFacultad;
}
