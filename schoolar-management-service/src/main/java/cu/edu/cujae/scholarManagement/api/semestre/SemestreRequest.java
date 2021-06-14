package cu.edu.cujae.scholarManagement.api.semestre;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class SemestreRequest {

    private String semestre;
    private Integer activo;
}
