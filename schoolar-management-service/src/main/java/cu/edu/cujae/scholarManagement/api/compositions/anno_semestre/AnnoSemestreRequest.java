package cu.edu.cujae.scholarManagement.api.compositions.anno_semestre;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class AnnoSemestreRequest {
    private Integer idAnno;
    private Integer idSemestre;
}
