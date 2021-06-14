package cu.edu.cujae.scholarManagement.dto;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class AnnoSemestreDto {
    private Integer idAnno;
    private Integer idSemestre;
    private AnnoDto annoByIdAnno;
    private SemestreDto semestreByIdSemestre;




}
