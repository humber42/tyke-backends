package cu.edu.cujae.scholarManagement.api.compositions.asignatura_tema;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class AsignaturaTemaRequest {
    private Integer idAsignatura;
    private Integer idTema;
}
