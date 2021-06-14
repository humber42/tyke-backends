package cu.edu.cujae.scholarManagement.dto;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class SemestreDto {
    private Integer id;
    private String semestre;
    private Integer activo;
    private Collection<AnnoSemestreDto> annoSemestresById;
    private Collection<SemestreAsignaturaDto> semestreAsignaturasById;


}
