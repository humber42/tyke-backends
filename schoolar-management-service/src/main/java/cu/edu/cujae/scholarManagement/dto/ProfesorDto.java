package cu.edu.cujae.scholarManagement.dto;

import lombok.*;

import java.util.Collection;

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
    private int idFacultad;
    private Integer idUsuario;
    private UsuarioDto usuario;
    private Collection<AsignaturaProfesorGrupoDto> asignaturaProfesorGruposById;
    private FacultadDto facultadByIdFacultad;

}
