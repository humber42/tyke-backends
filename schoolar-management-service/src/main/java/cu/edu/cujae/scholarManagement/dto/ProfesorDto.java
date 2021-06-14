package cu.edu.cujae.scholarManagement.dto;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProfesorDto {
    private Integer id;
    private String gradoCientifico;
    private String gradoDocente;
    private String telefono;
    private int id_usuario;
    private UsuarioDto usuario;
    private Collection<AsignaturaProfesorEstudianteDto> asignaturaProfesorEstudiantesById;
    private FacultadDto facultadByIdFacultad;

}
