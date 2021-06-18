package cu.edu.cujae.scholarManagement.dto;

import lombok.*;

import java.util.Collection;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class EstudianteDto {
    private Integer id;
    private int idUsuario;
    private UsuarioDto usuario;
    private int idFacultad;
    private FacultadDto facultadByIdFacultad;
    private Collection<EstudianteGrupoDto> estudianteGruposById;
}
