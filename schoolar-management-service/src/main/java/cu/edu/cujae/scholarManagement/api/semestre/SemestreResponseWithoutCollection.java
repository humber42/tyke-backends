package cu.edu.cujae.scholarManagement.api.semestre;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class SemestreResponseWithoutCollection {
    private Integer id;
    private String semestre;
    private Integer activo;
}
