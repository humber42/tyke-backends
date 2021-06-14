package cu.edu.cujae.scholarManagement.api.curso;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class CursoResponseWithoutCollections {
    private int id;
    private String curso;
    private Boolean activo;
}
