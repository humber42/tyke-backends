package cu.edu.cujae.scholarManagement.api.compositions.signature_career;

import cu.edu.cujae.scholarManagement.api.asignatura.AsignaturaResponseWithoutCollections;
import cu.edu.cujae.scholarManagement.api.carrera.CarreraResponseWhithoutFaculty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class SignatureCareerResponse {
    private CarreraResponseWhithoutFaculty carreraByIdCareer;
    private AsignaturaResponseWithoutCollections asignaturaByIdSignature;
}
