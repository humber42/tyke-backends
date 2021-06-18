package cu.edu.cujae.scholarManagement.api.carrera;


import cu.edu.cujae.scholarManagement.api.compositions.signature_career.SignatureCareerResponse;
import cu.edu.cujae.scholarManagement.api.facultad.FacultadResponseWithoutCarreer;
import cu.edu.cujae.scholarManagement.api.grupo.GrupoResponse;
import cu.edu.cujae.scholarManagement.api.grupo.GrupoResponseWithoutCollections;
import lombok.*;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarreraResponse {
    private Integer id;
    private String nombre;
    private String siglas;
    private FacultadResponseWithoutCarreer facultad;
    private Collection<SignatureCareerResponse> signatureCareersById;
    private Collection<GrupoResponseWithoutCollections> gruposById;
}
