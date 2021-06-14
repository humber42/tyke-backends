package cu.edu.cujae.scholarManagement.api.compositions.anno_semestre;

import cu.edu.cujae.scholarManagement.api.anno.AnnoResponseWithoutCollections;
import cu.edu.cujae.scholarManagement.api.semestre.SemestreResponseWithoutCollection;
import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AnnoSemestreResponse {
    private AnnoResponseWithoutCollections annoByIdAnno;
    private SemestreResponseWithoutCollection semestreByIdSemestre;
}
