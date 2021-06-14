package cu.edu.cujae.scholarManagement.dto;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class EstudianteDto {
    private Integer id;
    private int id_usuario;
    private UsuarioDto usuario;
    private int id_facultad;
    private FacultadDto facultadByIdFacultad;
    private Collection<AsignaturaProfesorEstudianteDto> asignaturaProfesorEstudiantesById;
    private Collection<EstudianteGrupoDto> estudianteGruposById;




}
