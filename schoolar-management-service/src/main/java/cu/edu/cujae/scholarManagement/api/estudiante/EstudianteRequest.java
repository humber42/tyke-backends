package cu.edu.cujae.scholarManagement.api.estudiante;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class EstudianteRequest {
    private int id_usuario;
    private int id_facultad;

}
