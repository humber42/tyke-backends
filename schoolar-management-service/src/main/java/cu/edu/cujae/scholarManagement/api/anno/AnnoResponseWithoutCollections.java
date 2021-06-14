package cu.edu.cujae.scholarManagement.api.anno;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class AnnoResponseWithoutCollections {
    private Integer id;
    private String anno;
}
