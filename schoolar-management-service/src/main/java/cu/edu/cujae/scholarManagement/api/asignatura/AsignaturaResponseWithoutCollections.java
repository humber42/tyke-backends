package cu.edu.cujae.scholarManagement.api.asignatura;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class AsignaturaResponseWithoutCollections {
    private Integer id;
    private String nombre;
    private Boolean activo;
}
