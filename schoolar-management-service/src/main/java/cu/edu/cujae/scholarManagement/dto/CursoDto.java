package cu.edu.cujae.scholarManagement.dto;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class CursoDto {
    private Integer id;
    private String curso;
    private Boolean activo;
    private Collection<CursoAnnoDto> cursoAnnosById;
    private Collection<EstudianteGrupoDto> estudianteGruposById;
    private Collection<FacultadCursoDto> facultadCursosById;


}
