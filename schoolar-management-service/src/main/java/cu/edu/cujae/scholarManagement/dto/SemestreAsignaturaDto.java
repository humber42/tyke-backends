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
public class SemestreAsignaturaDto {
    private Integer idSemestre;
    private Integer idAsignatura;
    private SemestreDto semestreByIdSemestre;
    private AsignaturaDto asignaturaByIdAsignatura;


}
