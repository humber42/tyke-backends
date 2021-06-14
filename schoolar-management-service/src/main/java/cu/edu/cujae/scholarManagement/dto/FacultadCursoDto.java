package cu.edu.cujae.scholarManagement.dto;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@EqualsAndHashCode
public class FacultadCursoDto {
    private Integer idFacultad;
    private Integer idCurso;
    private FacultadDto facultadByIdFacultad;
    private CursoDto cursoByIdCurso;


}
