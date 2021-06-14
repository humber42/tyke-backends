package cu.edu.cujae.scholarManagement.api.tema;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class TemaRequest {
    private String nombre;
    private String description;
    private List<String> asignaturas;
}
