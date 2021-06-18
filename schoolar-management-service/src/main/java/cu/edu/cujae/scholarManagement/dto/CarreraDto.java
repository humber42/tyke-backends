package cu.edu.cujae.scholarManagement.dto;

import lombok.*;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class CarreraDto {
    private Integer id;
    private String nombre;
    private String siglas;
    private FacultadDto facultadByIdFacultad;
    private Integer idFacultad;
    private Collection<SignatureCarreraDto> signatureCareersById;
    private Collection<GrupoDto> gruposById;
}
