package cu.edu.cujae.scholarManagement.api.asignatura;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AsignaturaRequest {
    private String nombre;
    private String semestre;
    private boolean activo;
}
