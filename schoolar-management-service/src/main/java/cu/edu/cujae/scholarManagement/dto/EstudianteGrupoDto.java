package cu.edu.cujae.scholarManagement.dto;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class EstudianteGrupoDto {
    private Integer idEstudiante;
    private Integer idGrupo;
    private Integer idCurso;
    private Integer idAnno;
    private EstudianteDto estudianteByIdEstudiante;
    private GrupoDto grupoByIdGrupo;
    private CursoDto cursoByIdCurso;
    private AnnoDto annoByIdAnno;



}
