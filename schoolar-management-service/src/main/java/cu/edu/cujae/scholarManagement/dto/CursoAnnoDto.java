package cu.edu.cujae.scholarManagement.dto;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class CursoAnnoDto {
    private Integer idCurso;
    private Integer idAnno;
    private CursoDto cursoByIdCurso;
    private AnnoDto annoByIdAnno;




}
