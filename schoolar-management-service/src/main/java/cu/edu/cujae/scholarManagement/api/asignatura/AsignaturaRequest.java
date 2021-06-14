package cu.edu.cujae.scholarManagement.api.asignatura;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AsignaturaRequest {
    private String nombre;
    private boolean activo;
}
