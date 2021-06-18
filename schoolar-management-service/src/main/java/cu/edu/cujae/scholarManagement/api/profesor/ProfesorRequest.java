package cu.edu.cujae.scholarManagement.api.profesor;

import lombok.*;

@EqualsAndHashCode
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Builder
public class ProfesorRequest {
    private String gradoCientifico;
    private String gradoDocente;
    private String telefono;
    private String facultad;
    private String usuario;
}
