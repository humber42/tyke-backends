package cu.edu.cujae.scholarManagement.api.tema;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class TemaResponseWithoutCollections {
    private Integer id;
    private String nombre;
    private String description;

}
