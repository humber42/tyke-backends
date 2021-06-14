package cu.edu.cujae.scholarManagement.dto;

import lombok.*;


@EqualsAndHashCode
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignatureCarreraDto {
    private long id;
    private Integer idFaculty;
    private Integer idSignature;
    private CarreraDto carreradByIdCarrera;
    private AsignaturaDto asignaturaByIdSignature;
}
