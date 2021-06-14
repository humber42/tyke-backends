package cu.edu.cujae.scholarManagement.api.profesor;

import lombok.*;

@EqualsAndHashCode
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Builder
public class ProfesorRequest {
    private String nombre;
    private String apellidos;
    private String gradoCientifico;
    private String gradoDocente;
    private String telefono;
    private String correo;
}
