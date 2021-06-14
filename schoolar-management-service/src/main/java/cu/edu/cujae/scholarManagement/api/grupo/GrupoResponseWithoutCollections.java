package cu.edu.cujae.scholarManagement.api.grupo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class GrupoResponseWithoutCollections {
    private Long id;
    private String grupo;
}
