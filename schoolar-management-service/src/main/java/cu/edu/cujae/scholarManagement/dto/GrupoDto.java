package cu.edu.cujae.scholarManagement.dto;

import cu.edu.cujae.scholarManagement.domain.AsignaturaProfesorGrupoEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class GrupoDto {
    private Long id;
    private String grupo;
    private Collection<AnnoGrupoDto> annoGruposById;
    private Collection<EstudianteGrupoDto> estudianteGruposById;
    private Collection<AsignaturaProfesorGrupoDto> asignaturaProfesorGruposById;
    private Integer idCarrera;
    private CarreraDto carreraByIdCarrera;


}
