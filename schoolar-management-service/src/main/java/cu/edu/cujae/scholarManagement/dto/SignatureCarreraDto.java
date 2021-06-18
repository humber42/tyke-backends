package cu.edu.cujae.scholarManagement.dto;

import lombok.*;


@EqualsAndHashCode
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignatureCarreraDto {
    private long id;
    private Integer idCareer;
    private Integer idSignature;
    private CarreraDto carreraByIdCareer;
    private AsignaturaDto asignaturaByIdSignature;
}
