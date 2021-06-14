package cu.edu.cujae.scholarManagement.dto;

import lombok.*;

import java.util.Collection;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class AnnoDto {
    private Integer id;
    private String anno;
    private Collection<AnnoGrupoDto> annoGruposById;
    private Collection<AnnoSemestreDto> annoSemestresById;
    private Collection<CursoAnnoDto> cursoAnnosById;
    private Collection<EstudianteGrupoDto> estudianteGruposById;
}
