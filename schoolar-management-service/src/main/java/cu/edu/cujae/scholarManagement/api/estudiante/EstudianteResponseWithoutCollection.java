package cu.edu.cujae.scholarManagement.api.estudiante;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class EstudianteResponseWithoutCollection {
    private Integer id;
    private String nombre;
    private String apellido;
    private String sexo;
    private String correo;
    private int id_usuario;
}
